package com.example.quizapp.model;

import jakarta.persistence.*;

@Entity
public class QuizSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private int questionAnswered = 0;

    private int incorrectAnswers = 0;

    // Default constructor
    public QuizSession() {}

    // Constructor
    public QuizSession(Long userId) {
        this.userId = userId;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public int getQuestionAnswered() {
        return questionAnswered;
    }

    public void setQuestionAnswered(int questionAnswered) {
        this.questionAnswered = questionAnswered;
    }

    public int getIncorrectAnswers() {
        return incorrectAnswers;
    }

    public void setIncorrectAnswers(int incorrectAnswers) {
        this.incorrectAnswers = incorrectAnswers;
    }
}
