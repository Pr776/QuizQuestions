package com.priyanka.Microservices.controller;

import com.priyanka.Microservices.entity.QuestionClass;
import com.priyanka.Microservices.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/question")
public class QuestionController {

 @Autowired
    private QuestionService questionService;

    @PostMapping
    public ResponseEntity<QuestionClass> createQuestion(@RequestBody QuestionClass question) {
        return questionService.createQuestion(question);

    }
    @GetMapping
    public ResponseEntity<List<QuestionClass>> getAllQuestion(){
        return questionService.getAllQuestion();
    }
    @GetMapping("category/{category}")
    public ResponseEntity<List<QuestionClass>>getQuestionsByCategory(@PathVariable String category){
        return questionService.getQuestionsByCategory(category);
    }


}
