package com.priyanka.Microservices.controller;

import com.priyanka.Microservices.entity.QuestionClass;
import com.priyanka.Microservices.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/question")
public class QuestionController {

 @Autowired
    private QuestionService questionService;

    @PostMapping
    public QuestionClass createQuestion(@RequestBody QuestionClass question) {
        return questionService.createQuestion(question);

    }
    @GetMapping
    public List<QuestionClass> getAllQuestion(){

        return questionService.getAllQuestion();
    }


}
