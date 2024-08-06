package com.priyanka.Microservices.services.serviceImpl;

import com.priyanka.Microservices.entity.QuestionClass;
import com.priyanka.Microservices.entity.QuizClass;
import com.priyanka.Microservices.payload.QuestionWrapper;
import com.priyanka.Microservices.repository.QuestionRepository;
import com.priyanka.Microservices.repository.QuizRepository;
import com.priyanka.Microservices.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    QuizRepository quizRepository;
    @Autowired
    QuestionRepository questionRepository;
    @Override
    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
        List<QuestionClass> questionClass=questionRepository.findRandomQuestionsByCategory(category,numQ);
        QuizClass quizClass=new QuizClass();
        quizClass.setTitle(title);
        quizClass.setQuestions(questionClass);
        quizRepository.save(quizClass);
        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
        Optional<QuizClass> quizClass=quizRepository.findById(id);
        List<QuestionClass> questionClasses=quizClass.get().getQuestions();
        List<QuestionWrapper> questionWrappers=new ArrayList<>();
        for(QuestionClass q:questionClasses){
            QuestionWrapper qw=new QuestionWrapper(q.getId(),q.getQuestion(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
            questionWrappers.add(qw);
        }
        return new ResponseEntity<>(questionWrappers,HttpStatus.OK);
    }
}
