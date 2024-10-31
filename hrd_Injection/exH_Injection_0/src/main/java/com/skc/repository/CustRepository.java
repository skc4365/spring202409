package com.skc.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.skc.dto.CustDTO;

@Repository
@Mapper
public interface CustRepository {

	@Select("SELECT \r\n"
			+ "	p_no, \r\n"
			+ "	p_name, \r\n"
			+ "	DATE_FORMAT(p_birth, '%Y년 %m월 %d일') AS p_birth,\r\n"
			+ "	CONCAT(p_tel1,'-',p_tel2,'-',p_tel3) AS p_tel, \r\n"
			+ "	CASE\r\n"
			+ "		when p_city = '10'then '서울'\r\n"
			+ "		when p_city = '20'then '경기'\r\n"
			+ "		when p_city = '30'then '부산'\r\n"
			+ "		when p_city = '40'then '대구'\r\n"
			+ "		else '기타'\r\n"
			+ "	END p_city,\r\n"
			+ "	CASE\r\n"
			+ "		when p_gender = 'M'then '남'\r\n"
			+ "		when p_gender = 'F'then '여'\r\n"
			+ "		else '기타'\r\n"
			+ "	END p_gender\r\n"
			+ "FROM custtbl")
	public List<CustDTO> findAll();
}
