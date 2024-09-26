package com.example.quiz.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.quiz.entity.Quiz;
import com.example.quiz.repository.QuizRepository;

@Service
public class QuizServiceImpl implements QuizService {

	@Autowired
	QuizRepository repository;

	@Override
	public Iterable<Quiz> selectAll() {

		return repository.findAll();
	}

	@Override
	public Optional<Quiz> selectOneById(Integer id) {

		return repository.findById(id);
	}

	@Override
	public Optional<Quiz> selectOneRandomQuiz() {
		// 랜덤 id 가져오기
		Integer randId = repository.getRandomId();

		if (randId == null)
			// quiz테이블이 없어서 randID가 없다면 빈optional 반환
			return Optional.empty();

		return repository.findById(randId);
	}

	@Override
	public Boolean checkQuiz(Integer id, Boolean myAnswer) {

		Boolean check = false;

		Optional<Quiz> optQuiz = repository.findById(id);

		if (optQuiz.isPresent()) {
			Quiz quiz = optQuiz.get();

			if (quiz.getAnswer().equals(myAnswer)) {
				check = true;
			}
		}
		return check;
	}

	@Override
	public void insertQuiz(Quiz quiz) {
		repository.save(quiz);

	}

	@Override
	public void updateQuiz(Quiz quiz) {
		repository.save(quiz);

	}

	@Override
	public void deleteQuizById(Integer id) {
		repository.deleteById(id);
	}

}
