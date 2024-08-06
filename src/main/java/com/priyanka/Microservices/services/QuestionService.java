package com.priyanka.Microservices.services;

import com.priyanka.Microservices.entity.QuestionClass;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface QuestionService {
    ResponseEntity<QuestionClass >createQuestion(QuestionClass question);

    ResponseEntity<List<QuestionClass>>getAllQuestion();

    ResponseEntity<List<QuestionClass>>getQuestionsByCategory(String category);
}
