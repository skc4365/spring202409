package com.skc.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.skc.dto.InjectionDTO;

@Repository
@Mapper
public interface InjectionRepository {

	@Select("SELECT i.i_code AS i_code, i_name, COUNT(*) AS i_cnt\r\n"
			+ "FROM ordertbl o, injectiontbl i\r\n"
			+ "WHERE o.i_code = i.i_code\r\n"
			+ "GROUP BY i.i_code, i.i_name\r\n"
			+ "ORDER BY i.i_code;")
	public List<InjectionDTO> findAll();
}