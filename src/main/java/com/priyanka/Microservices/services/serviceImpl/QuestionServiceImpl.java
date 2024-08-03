package com.priyanka.Microservices.services.serviceImpl;

import com.priyanka.Microservices.entity.QuestionClass;
import com.priyanka.Microservices.repository.QuestionRepository;
import com.priyanka.Microservices.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    private QuestionRepository questionRepository;


    @Autowired
    public void QuestionService(QuestionRepository questionRepository) {

        this.questionRepository = questionRepository;
    }

    @Override
    public QuestionClass createQuestion(QuestionClass question) {
        return questionRepository.save(question);
    }

    @Override
    public List<QuestionClass> getAllQuestion() {
        return questionRepository.findAll();
    }
}
