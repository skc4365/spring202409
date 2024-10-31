package com.skc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.skc.dto.CustDTO;
import com.skc.repository.CustRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustService {

private final CustRepository repo;
	
	public List<CustDTO> findAll(){
		return repo.findAll();
	}
}
