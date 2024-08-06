package com.priyanka.Microservices.repository;

import com.priyanka.Microservices.entity.QuestionClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuestionRepository extends JpaRepository<QuestionClass,Long>{

    List<QuestionClass> findByCategory(String category);

    @Query(value = "SELECT * FROM question_class q WHERE q.category = :category ORDER BY RAND() LIMIT :numQ", nativeQuery = true)
    List<QuestionClass> findRandomQuestionsByCategory(@Param("category") String category,@Param("numQ") int numQ);
}
