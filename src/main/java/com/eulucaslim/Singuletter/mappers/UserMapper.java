package com.eulucaslim.Singuletter.mappers;

import com.eulucaslim.Singuletter.dto.UserDTO;
import com.eulucaslim.Singuletter.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDTO toDTO(User user){
        UserDTO dto = new UserDTO(user.getUsername(), user.getPassword(), user.getPassword());
        return dto;
    }

    public User toEntity(UserDTO dto){
        User user = new User();
        user.setId(null);
        user.setUsername(dto.username());
        user.setPassword(dto.password());
        user.setEmail(dto.email());
        return user;
    }
}
