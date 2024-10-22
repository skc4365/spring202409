package com.skc.repository;


import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.skc.dto.MemberDTO;

@Repository
public class MemberRepository {

	@Autowired
	private SqlSessionTemplate sql;

	public MemberDTO save(MemberDTO dto) {
		sql.insert("Member.save", dto);
		return dto;
	}

	public List<MemberDTO> findAll() {
		return sql.selectList("Member.findAll");
	}

	public MemberDTO findById(Integer id) {
		return sql.selectOne("Member.findById", id);
	}

	public void update(MemberDTO dto) {
		sql.update("Member.update", dto);
	}

	public void delete(Integer id) {
		sql.delete("Member.delete", id);
	}

}

