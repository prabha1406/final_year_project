package com.exam.exam_system.service;

import com.exam.exam_system.entity.User;
import com.exam.exam_system.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    // Register user
    public User register(User user) {
        // 1️⃣ Null checks
        if(user.getName() == null || user.getName().isEmpty()) {
            throw new RuntimeException("Name is required!");
        }
        if(user.getEmail() == null || user.getEmail().isEmpty()) {
            throw new RuntimeException("Email is required!");
        }
        if(user.getPassword() == null || user.getPassword().isEmpty()) {
            throw new RuntimeException("Password is required!");
        }
        if(user.getRole() == null) {
            throw new RuntimeException("Role is required!");
        }

        // 2️⃣ Optional: check duplicate email
        if(userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new RuntimeException("Email already exists!");
        }


        // 3️⃣ Hash password
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // 4️⃣ Save user
        return userRepository.save(user);
    }


    // Login user
    public Optional<User> login(String email, String password) {
        Optional<User> userOpt = userRepository.findByEmail(email);
        if(userOpt.isPresent() && passwordEncoder.matches(password, userOpt.get().getPassword())) {
            return userOpt;
        }
        return Optional.empty();
    }
}
