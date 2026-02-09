package com.exam.exam_system.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.exam.exam_system.entity.Student;
import com.exam.exam_system.repository.StudentRepository;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    // Constructor Injection (best practice)
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // Save student
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    // Get all students
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}
