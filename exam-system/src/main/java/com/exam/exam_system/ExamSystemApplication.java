package com.exam.exam_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan; // ← ADD THIS

@SpringBootApplication
@ComponentScan(basePackages = "com.exam.exam_system") // optional if all packages are under main package
public class ExamSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(ExamSystemApplication.class, args);
    }
}
