package com.priyanka.Microservices.repository;

import com.priyanka.Microservices.entity.QuestionClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<QuestionClass,Long>{

}
