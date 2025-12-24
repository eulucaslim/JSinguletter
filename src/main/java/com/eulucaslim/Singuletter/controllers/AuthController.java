package com.eulucaslim.Singuletter.controllers;

import com.eulucaslim.Singuletter.config.JwtUtil;
import com.eulucaslim.Singuletter.dto.requests.LoginUserRequestDTO;
import com.eulucaslim.Singuletter.dto.requests.RegisterUserRequestDTO;
import com.eulucaslim.Singuletter.dto.responses.UserResponseDTO;
import com.eulucaslim.Singuletter.entity.User;
import com.eulucaslim.Singuletter.mappers.UserMapper;
import com.eulucaslim.Singuletter.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final UserMapper userMapper;

    public AuthController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> register(@Valid @RequestBody RegisterUserRequestDTO userDTO){
        User user = userMapper.toEntity(userDTO);
        User userSaved = userService.register(user);
        return new ResponseEntity<>(userMapper.toDTO(userSaved), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginUserRequestDTO userDTO){
        User user = userService.getByUsername(userDTO.username());
        if (userService.authenticate(userDTO.password(), user.getPassword())){
            String token = JwtUtil.generateToken(user.getUsername());
            return ResponseEntity.ok().body(Map.of("token", token));
        }
        return ResponseEntity.status(401).body("Credentials Invalid!");
    }

}
