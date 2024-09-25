package com.example.quiz;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.quiz.entity.Quiz;
import com.example.quiz.repository.QuizRepository;

@SpringBootApplication
public class QuizApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuizApplication.class, args).getBean(QuizApplication.class).execute();
	}

	@Autowired
	QuizRepository repository;

	private void execute() {
		// 자료입력
		// setup();

		// 자료 전체 출력
		showList();

		// 1건 취득
		// showOne();

		// 변경 처리
		// updateQuiz();

		// 삭제 처리
		// deleteQuiz();

	}

	private void deleteQuiz() {
		System.out.println("----------삭제 처리 start-----");
		// repository.deleteById(14);
		System.out.println("----------삭제 처리 start-----");
	}

	private void updateQuiz() {
		System.out.println("----------변경 처리 start-----");
		// Quiz quiz1 = new Quiz(1, "스프링은 프레임웍??", true, "변경 담당");
		// quiz1 = repository.save(quiz1);
		// System.out.println("변경된 데이터는 " + quiz1 + "입니다.");
		System.out.println("----------변경 처리 end-----");
	}

	private void showOne() {
		System.out.println("---------- 1건 취득 start-----");
//		Optional<Quiz> quizOpt = repository.findById(1);
//		if (quizOpt.isPresent()) {
//			System.out.println(quizOpt.get());
//		} else {
//			System.out.println("해당 데이터는 존재하지 않습니다.");
//		}
		System.out.println("---------- 1건 취득 end-----");
	}

	private void showList() {

		System.out.println("----데이터 취득 start------");

		Iterable<Quiz> quizzes = repository.findAll();
		for (Quiz quiz : quizzes) {
			System.out.println(quiz);
		}

		System.out.println("----데이터 취득 end------");
	}

	private void setup() {
		// 엔티티
		Quiz quiz1 = new Quiz(null, "Spring은 프레임워크입니까?", true, "홍길동");
		quiz1 = repository.save(quiz1);
		System.out.println("등록한 퀴즈는 " + quiz1 + "입니다.");

		Quiz quiz2 = new Quiz(null, "스프링 MVC는 배치 처리를 제공합니까?", false, "홍길동");
		quiz2 = repository.save(quiz2);
		System.out.println("등록한 퀴즈는 " + quiz2 + "입니다.");

	}

}
