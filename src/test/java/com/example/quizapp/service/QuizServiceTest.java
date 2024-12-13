

package com.example.quizapp.service;

import com.example.quizapp.model.QuizSession;
import com.example.quizapp.repository.QuizSessionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest
public class QuizServiceTest {

    @Mock
    private QuizSessionRepository quizSessionRepository;

    @InjectMocks
    private QuizService quizService;

    private QuizSession quizSession;

    @BeforeEach
    public void setup() {
        quizSession = new QuizSession(1L);
    }

    @Test
    public void testStartQuizSession() {
        when(quizSessionRepository.save(Mockito.any(QuizSession.class))).thenReturn(quizSession);
        QuizSession result = quizService.startQuizSession(1L);
        assertNotNull(result);
    }
}
