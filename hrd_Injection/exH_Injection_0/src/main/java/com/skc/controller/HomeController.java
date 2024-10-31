package com.skc.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.skc.dto.CustDTO;
import com.skc.dto.InjectionDTO;
import com.skc.dto.OrderDTO;
import com.skc.service.CustService;
import com.skc.service.InjectionService;
import com.skc.service.OrderService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class HomeController {
	
	private final OrderService orderService;
	private final CustService custService;
	private final InjectionService injectionService;
	
	// 주사접종 ----------
	@GetMapping("/saveOrder")
	public String save() {
		return "saveOrder";
	}
	
	@PostMapping("/saveOrder")
	public String save(OrderDTO dto) {
		orderService.save(dto);
		return "redirect:/";
	}
	
	@GetMapping("/")
	public String findAllOrder(Model model) {
		List<OrderDTO> list = orderService.findAll();
		model.addAttribute("orderList", list);
		return "index";
	}
	
	@GetMapping("/{id}")
	public String findById(@PathVariable("id") Integer id, Model model) {
		OrderDTO dto = orderService.findById(id);
		model.addAttribute("order", dto);
		return "detail";
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable("id") Integer id, Model model) {
		OrderDTO dto = orderService.findById(id);
		model.addAttribute("order", dto);
		return "update";
	}
	
	@PostMapping("/update/{id}")
	public String update(OrderDTO dto, Model model) {
		orderService.update(dto);
		
		OrderDTO dto2 = orderService.findById(dto.getP_seno());
		model.addAttribute("order", dto2);
		return "detail";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id) {
		orderService.delete(id);
		return "redirect:/";
	}
	
	// 회원목록 조회 ----------
	@GetMapping("/listCust")
	public String listCust(Model m) {
		
		List<CustDTO> list = custService.findAll();
		m.addAttribute("custList", list);
		return "list_cust";
	}
	
	// 백신별 접종 조회 ----------
	@GetMapping("/listInjection")
	public String listInjection(Model m) {
		
		List<InjectionDTO> list = injectionService.findAll();
		m.addAttribute("injectionList", list);
		return "list_injection";
	}
	
	
}
