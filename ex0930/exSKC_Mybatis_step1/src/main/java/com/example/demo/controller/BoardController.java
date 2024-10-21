package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.demo.dto.BoardDTO;
import com.example.demo.service.BoardService;
import lombok.RequiredArgsConstructor;

/*
 * @RequiredArgsConstructor
 * final이 붙은 필드만, 생성자를 만들어준다
*/
@Controller
@RequiredArgsConstructor
public class BoardController {
	
	// 생성자 주입방식
	// Model 사용하기 위한 준비
	private final BoardService boardService;

	@GetMapping("/save")
	public String save() {
		return "save";
	}

	/*
	 * public String save(@ModelAttribute BoardDTO dto)
	 *       이떄, @ModelAttribute 생략가능
	 */
	@PostMapping("/save")
	public String save(BoardDTO boardDTO) {
		System.out.println("-----콘솔값을 확인하자 ㅎ-----");
		System.out.println("DTO = " + boardDTO);
		return "index";
	}
}
