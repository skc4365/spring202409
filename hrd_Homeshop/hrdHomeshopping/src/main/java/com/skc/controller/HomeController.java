package com.skc.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.skc.dto.MemberDTO;
import com.skc.service.MemberService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class HomeController {

	private final MemberService memberService;

	@GetMapping("/index")
	public String home() {
		return "index";
	}

	@GetMapping("/save")
	public String save() {
		return "save";
	}

	@PostMapping("/save")
	public String save(MemberDTO dto) {
		System.out.println("DTO = " + dto);
		memberService.save(dto);
		return "redirect:/list";
	}

	@GetMapping("/list")
	public String findAll(Model model) {
		List<MemberDTO> memberDTOList = memberService.findAll();
		model.addAttribute("memberList", memberDTOList);
		System.out.println("memberDTOList = " + memberDTOList);
		return "list";
	}

	@GetMapping("/{custno}")
	public String findById(@PathVariable("custno") Integer custno, Model model) {
		// 상세내용 가져옴
		MemberDTO memberDTO = memberService.findById(custno);
		model.addAttribute("member", memberDTO);
		System.out.println("memberDTO = " + memberDTO);
		return "detail";
	}

	@GetMapping("/update/{custno}")
	public String update(@PathVariable("custno") Integer custno, Model model) {
		MemberDTO memberDTO = memberService.findById(custno);
		model.addAttribute("member", memberDTO);
		return "update";
	}

	@PostMapping("/update/{custno}")
	public String update(MemberDTO memberDTO, Model model) {
		memberService.update(memberDTO);

		MemberDTO dto = memberService.findById(memberDTO.getCustno());
		model.addAttribute("member", dto);
		return "detail";
	}
	
    @GetMapping("/delete/{custno}")
    public String delete(@PathVariable("custno") Integer custno) {
    	memberService.delete(custno);
        return "redirect:/list";
    }
}
