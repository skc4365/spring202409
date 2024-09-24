package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.form.CalcForm;

@Controller
public class ValidationController {

//	entry.html----- th:object="${calcForm}"
//	화면에 바인딩될 bean을 설정하는 부분.
	@ModelAttribute
	public CalcForm setUpForm() {
		// 화면에서 사용할 클래스초기화
		return new CalcForm();
	}

	@GetMapping("show")
	public String showView() {
		return "entry";
	}

	@PostMapping("calc")
	public String confirmView(@Validated CalcForm form, BindingResult bindingResult, Model model) {
		//---@Validated:단일항목검사CalcForm, 검사결과오류유무BindingResult 참vs거짓
		if (bindingResult.hasErrors()) {
			// form화면에서 입력내용에 오류발생시 entry.html
			return "entry";
		}
		// 연산하기
		Integer result = form.getLeftNum() + form.getRightNum();
		// Model에 저장
		model.addAttribute("result", result);
		return "confirm";
	}
}
