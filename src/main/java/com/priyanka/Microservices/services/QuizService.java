package com.priyanka.Microservices.services;

import com.priyanka.Microservices.payload.QuestionWrapper;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface QuizService {
    ResponseEntity<String> createQuiz(String category, int numQ, String title);

    ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id);
}
