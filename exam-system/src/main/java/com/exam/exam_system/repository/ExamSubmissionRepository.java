package com.exam.exam_system.repository;

import com.exam.exam_system.entity.ExamSubmission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamSubmissionRepository extends JpaRepository<ExamSubmission, Long> {
    // Optional: add custom queries later
}
