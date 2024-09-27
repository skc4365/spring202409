package com.example.quiz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.quiz.entity.Quiz;

import com.example.quiz.service.QuizService;

@SpringBootApplication
public class QuizApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuizApplication.class, args);
	}

	// @Autowired
	// QuizRepository repository;

	@Autowired
	QuizService service;

	private void execute() {

		System.out.println("service_test");

		// 자료입력
		// setup();

		// 자료 전체 출력
		// showList();

		// 1건 취득
		// showOne();

		// 변경 처리
		// updateQuiz();

		// 삭제 처리
		// deleteQuiz();

		// 퀴즈 실행
		doQuiz();

	}

	private void doQuiz() {
		System.out.println("----------퀴즈 1건(랜덤) 취득-----start");
		Optional<Quiz> quizOpt = service.selectOneRandomQuiz();
		if (quizOpt.isPresent()) {
			System.out.println(quizOpt.get());
		} else {
			System.out.println("해당 데이터는 존재하지 않습니다.");
		}
		System.out.println("----------퀴즈 1건(랜덤) 취득-----end");

		// 답
		Boolean myAnswer = false;
		Integer id = quizOpt.get().getId();
		if (service.checkQuiz(id, myAnswer)) {
			System.out.println("정답O입니다.");
		} else {
			System.out.println("오답X입니다.");
		}

	}

	private void deleteQuiz() {
		System.out.println("----------삭제-----start");
		service.deleteQuizById(2);
		System.out.println("----------삭제-----end");
	}

	private void updateQuiz() {
		System.out.println("----------데이터 변경-----start");
		Quiz quiz1 = new Quiz(1, "스프링은 프레임워크입니까?", true, "변경 담당");

		service.updateQuiz(quiz1);

		System.out.println("변경된 데이터는 " + quiz1 + "입니다.");
		System.out.println("----------데이터 변경-----end");
	}

	private void showOne() {
		System.out.println("----------1건 데이터 취득-----start");
		Optional<Quiz> quizOpt = service.selectOneById(1);
		if (quizOpt.isPresent()) {
			System.out.println(quizOpt.get());
		} else {
			System.out.println("해당 데이터는 존재하지 안습니다.");
		}
		System.out.println("----------1건 데이터 취득-----end");
	}

	private void showList() {

		System.out.println("----------모든 데이터 취득-----start");
		Iterable<Quiz> quizzes = service.selectAll();
		for (Quiz q : quizzes) {
			System.out.println(q);
		}
		System.out.println("----------모든 데이터 취득-----end");
	}

	private void setup() {
		System.out.println("----------등록-----start");

		// java? 객체지향 언어
		Quiz quiz1 = new Quiz(null, "자바는 객체지향 언어입니다.", true, "등록 담당");
		// 스프링 데이터? 기본 데이터 저장소(DB)에 대한 특성은 유지하며, 데이터 액세스 방법을 제시.
		Quiz quiz2 = new Quiz(null, "스프링 데이터는 데이터 액세스에 관련된 기능을 제공합니다.", true, "등록 담당");
		// 라이브러리란? 자주 사용하는 기능을 class로 미리 만들어놓고 제공하는 것이다.
		Quiz quiz3 = new Quiz(null, "프로그램이 많이 등록되어 있는 서버를 라이브러리라고 합니다.", false, "등록 담당");
		// @component? 구성요소라는 뜻으로, 독립적인 단위모듈
		// @Component 어노테이션이 있는 클래스들에 대하여 Bean 인스턴스를 생성
		Quiz quiz4 = new Quiz(null, "@component는 인스턴스 생성 어노테이션입니다.", true, "등록 담당");
		// 싱글턴Singleton 디자인 패턴pattern?
		// 생성자가 여러번 호출되더라도 실제 객체는 하나뿐이다.
		Quiz quiz5 = new Quiz(null, "스프링MVC에서 구현하고 있는 디자인 패턴에서 모든 요청을 하나의 컨트롤러에서 받는 것을 싱글 컨트롤러 패턴이라고 합니다.", false,
				"등록 담당");

		List<Quiz> quizList = new ArrayList<>();
		Collections.addAll(quizList, quiz1, quiz2, quiz3, quiz4, quiz5);

		for (Quiz q : quizList) {
			service.insertQuiz(q);
			System.out.println(q);
		}
		System.out.println("----------등록-----end");
	}

}
