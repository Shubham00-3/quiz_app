package com.example.quizapp.configuration;


import com.example.quizapp.model.QuizQuestion;
import com.example.quizapp.repository.QuizQuestionRepository;
import com.example.quizapp.repository.QuizSessionRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Arrays;


@Component
public class DataSeeder {

    @Autowired
    private QuizQuestionRepository quizQuestionRepository;

    @PostConstruct
    public void seedQuestions() {
        if (quizQuestionRepository.count() == 0) {
            QuizQuestion quizQuestion1 = new QuizQuestion("What is the capital of India?", Arrays.asList("Delhi", "Chennai", "Mumbai", "Kolkata"), 0);
            QuizQuestion question2 = new QuizQuestion("What is 2+2?", Arrays.asList("3", "4", "5", "6"), 1);
            QuizQuestion question3 = new QuizQuestion("Who wrote 'Haar manunga nahi'?", Arrays.asList("Atal Bihari Vajpayee", "Ramadhir Singh Dinkar", "Kalidas", "Ahmad Faraz"), 0);
            QuizQuestion question4 = new QuizQuestion("Who wrote 'Romeo and Juliet'?", Arrays.asList("Shakespeare", "Charles Dickens", "Rudyard Kipling", "Robert Frost"), 0);

            quizQuestionRepository.saveAll(Arrays.asList(quizQuestion1, question2, question3, question4));
        }
    }
}
