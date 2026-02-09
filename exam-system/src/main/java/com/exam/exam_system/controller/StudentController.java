package com.exam.exam_system.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.exam.exam_system.entity.Student;
import com.exam.exam_system.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    // Constructor injection
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // Test API
    @GetMapping("/test")
    public String test() {
        return "Student Controller Working!";
    }

    // Save student
    @PostMapping
    public Student saveStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    // Get all students
    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

@GetMapping("/add")
public Student addStudentFromBrowser() {
    Student student = new Student();
    student.setName("Mohana");
    student.setEmail("mohana@gmail.com");
    return studentService.saveStudent(student);
}
}

