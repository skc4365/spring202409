package com.skc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.skc.dto.InjectionDTO;
import com.skc.repository.InjectionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InjectionService {

	private final InjectionRepository repo;

	public List<InjectionDTO> findAll() {
		return repo.findAll();
	}

}
