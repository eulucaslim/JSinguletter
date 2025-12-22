package com.eulucaslim.Singuletter.controllers;

import com.eulucaslim.Singuletter.config.JwtUtil;
import com.eulucaslim.Singuletter.dto.UserDTO;
import com.eulucaslim.Singuletter.entity.User;
import com.eulucaslim.Singuletter.mappers.UserMapper;
import com.eulucaslim.Singuletter.services.UserService;
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
    public ResponseEntity<UserDTO> register(@RequestBody UserDTO userDTO){
        User user = userMapper.toEntity(userDTO);
        User userSaved = userService.register(user);
        return ResponseEntity.ok(userMapper.toDTO(userSaved));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserDTO userDTO){
        User user = userService.getByUsername(userDTO.username());
        if (userService.authenticate(userDTO.password(), user.getPassword())){
            String token = JwtUtil.generateToken(user.getUsername());
            return ResponseEntity.ok(Map.of("token", token));
        }
        return ResponseEntity.status(401).body("Credentials Invalid!");
    }

}
