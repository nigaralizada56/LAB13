package com.example.SpringApp.service;

import com.example.SpringApp.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final List<User> users = new ArrayList<>(); // Simulated in-memory storage

    public User createUser(User user) {
        Optional<User> existingUser = users.stream()
                .filter(u -> u.getUsername().equals(user.getUsername()) || u.getEmail().equals(user.getEmail()))
                .findFirst();

        if (existingUser.isPresent()) {
            throw new RuntimeException("User already exists with username or email!");
        }

        users.add(user);
        return user;
    }

    public User findByUsername(String username) {
        return users.stream()
                .filter(user -> user.getUsername().equals(username))
                .findFirst()
                .orElse(null);
    }
}
