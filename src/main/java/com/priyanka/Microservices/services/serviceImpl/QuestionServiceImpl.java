package com.priyanka.Microservices.services.serviceImpl;

import com.priyanka.Microservices.entity.QuestionClass;
import com.priyanka.Microservices.repository.QuestionRepository;
import com.priyanka.Microservices.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<QuestionClass> createQuestion(QuestionClass question) {
        return new ResponseEntity<>(questionRepository.save(question),HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<QuestionClass>> getAllQuestion() {
        try {
            return new ResponseEntity<>(questionRepository.findAll(), HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(questionRepository.findAll(), HttpStatus.BAD_REQUEST);

    }

    @Override
    public ResponseEntity<List<QuestionClass>>getQuestionsByCategory(String category) {
        try {
            return new ResponseEntity<>(questionRepository.findByCategory(category),HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(questionRepository.findByCategory(category),HttpStatus.BAD_REQUEST);
        }

    }
}
