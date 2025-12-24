package com.eulucaslim.Singuletter.mappers;

import com.eulucaslim.Singuletter.dto.requests.RegisterUserRequestDTO;
import com.eulucaslim.Singuletter.dto.responses.UserResponseDTO;
import com.eulucaslim.Singuletter.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserResponseDTO toDTO(User user){
        UserResponseDTO dto = new UserResponseDTO(user.getId(), user.getUsername(), user.getEmail());
        return dto;
    }

    public User toEntity(RegisterUserRequestDTO dto){
        User user = new User();
        user.setId(null);
        user.setUsername(dto.username());
        user.setPassword(dto.password());
        user.setEmail(dto.email());
        return user;
    }
}
