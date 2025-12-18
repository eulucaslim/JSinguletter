package com.eulucaslim.Singuletter.mappers;

import com.eulucaslim.Singuletter.dto.UserDTO;
import com.eulucaslim.Singuletter.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDTO toDTO(User user){
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());
        return dto;
    }

    public User toEntity(UserDTO dto){
        User user = new User();
        user.setId(null);
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        user.setEmail(dto.getEmail());
        return user;
    }
}
