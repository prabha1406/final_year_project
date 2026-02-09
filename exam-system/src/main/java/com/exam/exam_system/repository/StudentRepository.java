package com.exam.exam_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.exam.exam_system.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
