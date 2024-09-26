package com.example.quiz.service;

import java.util.Optional;

import com.example.quiz.entity.Quiz;

public interface QuizService {

	// 퀴즈 전체 확인
	Iterable<Quiz> selectAll();

	// 퀴즈 확인(id)
	Optional<Quiz> selectOneById(Integer id);

	// 퀴즈 확인(random)
	Optional<Quiz> selectOneRandomQuiz();

	// 퀴즈 판단(true/false)
	Boolean checkQuiz(Integer id, Boolean myAnswer);

	// 퀴즈 입력
	void insertQuiz(Quiz quiz);

	// 퀴즈 수정
	void updateQuiz(Quiz quiz);

	// 퀴즈 삭제
	void deleteQuizById(Integer id);

}
