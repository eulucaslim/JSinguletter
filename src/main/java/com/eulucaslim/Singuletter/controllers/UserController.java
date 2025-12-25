package com.eulucaslim.Singuletter.controllers;

import com.eulucaslim.Singuletter.dto.responses.UserResponseDTO;
import com.eulucaslim.Singuletter.mappers.UserMapper;
import com.eulucaslim.Singuletter.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> findAll(){
        List<UserResponseDTO> users = userService.findAll().stream()
                .map(userMapper::toDTO)
                .toList();
        return ResponseEntity.ok().body(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> findById(@PathVariable Long id){
        UserResponseDTO user = userMapper.toDTO(userService.findById(id));
        return ResponseEntity.ok().body(user);
    }

}
