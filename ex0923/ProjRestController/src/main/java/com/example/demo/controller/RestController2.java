package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.obj.Member;

@RestController
@RequestMapping("rest")
public class RestController2 {

	@GetMapping("/r0")
	public String getMember() {

		return "restText";
	}

	// 전송1. /r1?name="홍길동" 파라메터name필수
	@GetMapping("/r1")
	public String getMemberName(@RequestParam("name") String name) {
		String result = "이름: " + name;
		return result;
	}

	// 전송2. /r2?name="홍길동"&age="22" 파라메터age선택
	@GetMapping("/r2")
	public String getMemberNameAge(@RequestParam("name") String name,
			@RequestParam(value = "age", required = false) String age) {
		String result = "이름: " + name + "| 나이: " + age;
		return result;
	}

	// 전송 객체. /r3?name="홍길동"&age=33 파라메터name,age필수
	@GetMapping("/r3")
	public Member getMemberObject(@RequestParam("name") String name, @RequestParam("age") int age) {
		Member member = new Member();
		member.setName(name);
		member.setAge(age);
		return member;
	}

}
