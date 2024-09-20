package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.obj.Member;

@Controller
@RequestMapping("/member")
public class RestController {

	@GetMapping("/m0")
	@ResponseBody
	public String getMember() {
		
		return "memberText";
	}
	
	// 전송1. /m1?name="홍길동" 파라메터name필수
	@GetMapping("/m1")
	@ResponseBody
	public String getMemberName(@RequestParam("name") String name) {
		
		String result = "이름: " + name;
		return result;
	}
	
	// 전송2. /m2?name="홍길동"&age="22" 파라메터age선택
	@GetMapping("/m2")
	@ResponseBody
	public String getMemberNameAge(
			@RequestParam("name") String name, 
			@RequestParam(value = "age", required = false) String age) {
		
		String result = "이름: " + name + "| 나이: " + age;
		return result;
	}
	
	// 전송 객체. /m3?name="홍길동"&age=33 파라메터name,age필수
	@GetMapping("/m3")
	@ResponseBody
	public Member getMemberObj(
			@RequestParam("name") String name, 
			@RequestParam("age") int age) {
		
		Member member = new Member();
		member.setName(name);
		member.setAge(age);
		
		return member;
	}
	
}










