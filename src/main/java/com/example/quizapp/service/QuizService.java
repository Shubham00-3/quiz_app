package com.example.quizapp.service;

import com.example.quizapp.model.QuizQuestion;
import com.example.quizapp.model.QuizSession;
import com.example.quizapp.repository.QuizQuestionRepository;
import com.example.quizapp.repository.QuizSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class QuizService {

    @Autowired
    private QuizQuestionRepository quizQuestionRepository;

    @Autowired
    private QuizSessionRepository quizSessionRepository;


    public QuizSession startQuizSession(long userId) {
        QuizSession quizSession = new QuizSession(userId);
        return quizSessionRepository.save(quizSession);
    }


    public QuizQuestion getRandomQuestion() {
        List<QuizQuestion> quizQuestions = quizQuestionRepository.findAll();
        if (quizQuestions.isEmpty()) {
            throw new IllegalStateException("No quiz questions available.");
        }
        Random random = new Random();
        return quizQuestions.get(random.nextInt(quizQuestions.size()));
    }


    public void submitAnswer(long sessionId, long questionId, int selectedOption) {
        QuizSession quizSession = quizSessionRepository.findById(sessionId)
                .orElseThrow(() -> new IllegalArgumentException("Quiz session not found."));
        QuizQuestion question = quizQuestionRepository.findById(questionId)
                .orElseThrow(() -> new IllegalArgumentException("Quiz question not found."));


        quizSession.setQuestionAnswered(quizSession.getQuestionAnswered() + 1);


        if (question.getCorrectOption() != selectedOption) {
            quizSession.setIncorrectAnswers(quizSession.getIncorrectAnswers() + 1);
        }


        quizSessionRepository.save(quizSession);
    }


    public QuizSession getQuizSessionStats(long sessionId) {
        return quizSessionRepository.findById(sessionId)
                .orElseThrow(() -> new IllegalArgumentException("Quiz session not found."));
    }
}
