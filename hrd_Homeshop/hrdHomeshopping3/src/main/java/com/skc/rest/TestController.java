package com.skc.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class TestController {

	// 순서2. 웹링크테스트
	@GetMapping("/test/myurl")
	public String select() {
		return "myurl 테스트중~";
	}
	
	@GetMapping("/test/index")
	public ModelAndView viewIndex() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("testIndex.html");
		return modelAndView;
		
	}
}
