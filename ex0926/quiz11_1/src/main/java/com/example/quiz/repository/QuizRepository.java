package com.example.quiz.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.quiz.entity.Quiz;

public interface QuizRepository extends CrudRepository<Quiz, Integer> {

	// quiz테이블에서 랜덤하게 하나의 ID값을 추출
	@Query("SELECT id FROM quiz ORDER BY random() limit 1")
	Integer getRandomId();

}
