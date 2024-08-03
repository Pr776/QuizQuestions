package com.priyanka.Microservices.services;

import com.priyanka.Microservices.entity.QuestionClass;
import org.springframework.stereotype.Service;

import java.util.List;

public interface QuestionService {
    QuestionClass createQuestion(QuestionClass question);

    List<QuestionClass> getAllQuestion();
}
