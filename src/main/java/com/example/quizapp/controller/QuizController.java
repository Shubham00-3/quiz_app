package com.example.quizapp.controller;

import com.example.quizapp.model.QuizSession;
import com.example.quizapp.model.QuizQuestion;
import com.example.quizapp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;


    @PostMapping("/start")
    public ResponseEntity<String> startQuizSession(@RequestParam long userId) {
        quizService.startQuizSession(userId);
        return ResponseEntity.ok("Quiz session started!");
    }


    @GetMapping("/question")
    public ResponseEntity<QuizQuestion> getRandomQuestion() {
        QuizQuestion question = quizService.getRandomQuestion();
        return ResponseEntity.ok(question);
    }


    @PostMapping("/submit")
    public ResponseEntity<String> submitAnswer(
            @RequestParam long sessionId,
            @RequestParam long questionId,
            @RequestParam int selectedOption) {
        quizService.submitAnswer(sessionId, questionId, selectedOption);
        return ResponseEntity.ok("Answer submitted!");
    }


    @GetMapping("/stats")
    public ResponseEntity<QuizSession> getQuizSessionStats(@RequestParam long sessionId) {
        QuizSession stats = quizService.getQuizSessionStats(sessionId);
        return ResponseEntity.ok(stats);
    }
}
