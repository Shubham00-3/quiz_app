package com.example.quizapp.controller;

import com.example.quizapp.model.QuizSession;
import com.example.quizapp.service.QuizService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
public class QuizControllerTest {

    @Mock
    private QuizService quizService;

    @InjectMocks
    private QuizController quizController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {

        mockMvc = MockMvcBuilders.standaloneSetup(quizController).build();
    }

    @Test
    public void testStartQuizSession() throws Exception {
        // Mock the startQuizSession method
        QuizSession mockQuizSession = new QuizSession(1L);
        when(quizService.startQuizSession(1L)).thenReturn(mockQuizSession);

        mockMvc.perform(post("/api/quiz/start?userId=1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.userId").value(1));
    }
}
