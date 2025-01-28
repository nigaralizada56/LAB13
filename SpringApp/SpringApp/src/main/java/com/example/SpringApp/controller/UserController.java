package com.example.SpringApp.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final String hardcodedUsername = "admin";
    private final String hardcodedPassword = "admin123";

    // Handle sign-up (POST only)
    @PostMapping("/signup")
    public String signUp(@RequestParam String username, @RequestParam String password) {
        // This is just a placeholder; implement actual signup logic here
        return "User " + username + " registered successfully!";
    }

    // Handle sign-in (GET and POST supported)
    @RequestMapping(value = "/signin", method = {RequestMethod.GET, RequestMethod.POST})
    public String signIn(@RequestParam(required = false) String username, @RequestParam(required = false) String password) {
        if (hardcodedUsername.equals(username) && hardcodedPassword.equals(password)) {
            return "Successful login!";
        } else if (username == null || password == null) {
            return "Please provide both username and password.";
        } else {
            return "Invalid credentials!";
        }
    }
}
