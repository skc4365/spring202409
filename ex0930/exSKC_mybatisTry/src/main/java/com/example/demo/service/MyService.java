package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.MyMapper;
import com.example.demo.model.Member;

import lombok.RequiredArgsConstructor;

@Service
public class MyService {
	@Autowired
	private MyMapper myMapper;

	public List<Member> selectMember() {
		return myMapper.selectMember();
	}
}
