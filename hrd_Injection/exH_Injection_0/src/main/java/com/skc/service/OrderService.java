package com.skc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.skc.dto.OrderDTO;
import com.skc.repository.OrderRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {
	
	private final OrderRepository orderRepository;
	
	public void save(OrderDTO dto) {
		orderRepository.save(dto);
	}
	
	public List<OrderDTO> findAll(){
		return orderRepository.findAll();
	}
	
	public OrderDTO findById(Integer id) {
		return orderRepository.findById(id);
	}
	
	public void update(OrderDTO dto) {
		orderRepository.update(dto); 
	}
	
	public void delete(Integer id) {
		orderRepository.delete(id);
	}

}
