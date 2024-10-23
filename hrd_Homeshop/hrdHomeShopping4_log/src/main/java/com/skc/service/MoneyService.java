package com.skc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skc.dto.MoneyDTO;
import com.skc.repository.MoneyRepository;

@Service
public class MoneyService {
	
	@Autowired
	private MoneyRepository moneyRepository;
	
	public List<MoneyDTO> findAll(){
		return moneyRepository.findAll();
	}

}
