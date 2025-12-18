package com.eulucaslim.Singuletter.services;

import com.eulucaslim.Singuletter.entity.User;
import com.eulucaslim.Singuletter.exceptions.NotFoundException;
import com.eulucaslim.Singuletter.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }


    public List<User> findAll(){
        List<User> users = repository.findAll();
        return users;
    }

    public User findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("User " + id + " Not Found!"));
    }

    public void create(User user) {
        if (!repository.existsByUsername(user.getUsername())) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            repository.save(user);
        }
    }

    public void update(User user) {
        repository.save(user);
    }
}
