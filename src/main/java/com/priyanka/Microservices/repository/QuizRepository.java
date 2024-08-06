package com.priyanka.Microservices.repository;

import com.priyanka.Microservices.entity.QuizClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<QuizClass,Integer> {
}
