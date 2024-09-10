package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.Member;
import com.example.demo.repository.MemberCrudRepository;

@SpringBootApplication
public class JdbcSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(JdbcSampleApplication.class, args).getBean(JdbcSampleApplication.class).execute();
	}

	@Autowired
	MemberCrudRepository repository;

	/**
	 * 등록과 모든 데이터 취득
	 */
	private void execute() {
		// 등록
		executeInsert();
		// 모든 데이터 취득
		executeSelect();
	}

	/**
	 * 등록
	 */
	private void executeInsert() {
		// 엔티티 생성(id와 자동 부여되기 때문에 null을 설정)
		Member member = new Member(null, "홍길동");
		// 리포지토리를 이용해서 등록 실행하고 결과를 취득
		member = repository.save(member);
		// 결과를 표시
		System.out.println("등록 데이터:" + member);
	}

	/**
	 * 전체 취득
	 */
	private void executeSelect() {
		System.out.println("--- 전체 데이터를 취득합니다 ---");
		// 리포지토리를 사용해서 전체 데이터를 취득
		Iterable<Member> members = repository.findAll();
		for (Member member : members) {
			System.out.println(member);
		}
	}

}
