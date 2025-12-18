package com.eulucaslim.Singuletter.services;

import com.eulucaslim.Singuletter.entity.User;
import com.eulucaslim.Singuletter.exceptions.CredentialsInvalid;
import com.eulucaslim.Singuletter.exceptions.EntityAlreadyExists;
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

    public User getByUsername(String username) {
        return repository.findByUsername(username)
                .orElseThrow(() -> new NotFoundException("User " + username + " Not Found!"));
    }

    public User register(User user) {
        if (repository.existsByUsername(user.getUsername())) {
            throw new EntityAlreadyExists("This User already exists!");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return repository.save(user);
    }

    public boolean authenticate(String passwordRequest, String passwordEncoded) {

        if (!passwordEncoder.matches(passwordRequest, passwordEncoded)){
            throw new CredentialsInvalid("Credentials Invalid!");
        }
        return true;
    }

}
