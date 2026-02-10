package com.exam.exam_system.controller;

import com.exam.exam_system.entity.User;
import com.exam.exam_system.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@CrossOrigin
public class UserController {

    private final UserService userService;

    public UserController(UserService service) {
        this.userService = service;
    }

    // Register endpoint
    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.register(user);
    }

    // Login endpoint
    @PostMapping("/login")
    public String login(@RequestBody User user) {
        Optional<User> u = userService.login(user.getEmail(), user.getPassword());
        if(u.isPresent()) {
            return "Login successful! Role: " + u.get().getRole();
        }
        return "Invalid credentials";
    }

    // Test endpoint (optional)
    @GetMapping("/test")
    public String test() {
        return "Controller is working!";
    }
}
