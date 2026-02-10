package com.exam.exam_system.entity;

import jakarta.persistence.*;
import java.util.Map;

@Entity
public class ExamSubmission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long examId;
    private String student;
    private int score;

    // Store answers as JSON string or Map
    @ElementCollection
    private Map<String, String> answers;

    // Analytics like averageScore, highestScore
    @ElementCollection
    private Map<String, Integer> analytics;

    // Constructors
    public ExamSubmission() {}

    public ExamSubmission(Long examId, String student, int score, Map<String, String> answers, Map<String, Integer> analytics) {
        this.examId = examId;
        this.student = student;
        this.score = score;
        this.answers = answers;
        this.analytics = analytics;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getExamId() { return examId; }
    public void setExamId(Long examId) { this.examId = examId; }

    public String getStudent() { return student; }
    public void setStudent(String student) { this.student = student; }

    public int getScore() { return score; }
    public void setScore(int score) { this.score = score; }

    public Map<String, String> getAnswers() { return answers; }
    public void setAnswers(Map<String, String> answers) { this.answers = answers; }

    public Map<String, Integer> getAnalytics() { return analytics; }
    public void setAnalytics(Map<String, Integer> analytics) { this.analytics = analytics; }
}
