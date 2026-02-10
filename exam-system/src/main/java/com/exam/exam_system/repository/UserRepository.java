package com.exam.exam_system.repository;

import com.exam.exam_system.entity.User;
import com.exam.exam_system.repository.UserRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
