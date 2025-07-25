package com.example.femivio.controller;

import com.example.femivio.model.User;
import com.example.femivio.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public Map<String, Object> register(@RequestBody User user) {
        Map<String, Object> response = new HashMap<>();
        userRepository.save(user);
        response.put("message", "User registered successfully");
        return response;
    }

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody Map<String, String> loginRequest) {
        String email = loginRequest.get("email");
        String password = loginRequest.get("password");
        User user = userRepository.findByEmailAndPassword(email, password);

        Map<String, Object> response = new HashMap<>();
        if (user != null) {
            response.put("message", "Login successful");
            response.put("user", user);
        } else {
            response.put("message", "Invalid email or password");
        }
        return response;
    }

    @GetMapping("/ping")
    public String ping() {
        return "Connected to backend";
    }
}