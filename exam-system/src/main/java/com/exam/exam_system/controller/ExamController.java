package com.exam.exam_system.controller;

import com.exam.exam_system.entity.ExamSubmission;
import com.exam.exam_system.repository.ExamSubmissionRepository;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/exams")
@CrossOrigin
public class ExamController {

    private final ExamSubmissionRepository examSubmissionRepository;

    public ExamController(ExamSubmissionRepository repository) {
        this.examSubmissionRepository = repository;
    }

    // Submit exam
    @PostMapping("/submit")
    public ExamSubmission submitExam(@RequestBody ExamSubmission submission) {
        // Example analytics calculation
        Map<String, Integer> analytics = new HashMap<>();
        analytics.put("averageScore", 78);   // Replace with real calculation
        analytics.put("highestScore", 95);   // Replace with real calculation
        submission.setAnalytics(analytics);

        return examSubmissionRepository.save(submission);
    }

    // Get all submissions
    @GetMapping("/submissions")
    public Iterable<ExamSubmission> getAllSubmissions() {
        return examSubmissionRepository.findAll();
    }

    // Optional: get submission by ID
    @GetMapping("/submission/{id}")
    public ExamSubmission getSubmissionById(@PathVariable Long id) {
        return examSubmissionRepository.findById(id)
                .orElse(null);
    }
}
