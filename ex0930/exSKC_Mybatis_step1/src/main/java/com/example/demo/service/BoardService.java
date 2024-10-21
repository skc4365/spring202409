package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.repository.BoardRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {
	// DB사용하기 위한 준비
	private final BoardRepository boardRepository;

}
