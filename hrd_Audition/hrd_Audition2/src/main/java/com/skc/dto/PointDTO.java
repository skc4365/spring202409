package com.skc.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PointDTO {

	// 테이블 필드
	private String serial_no;
	private String artist_id;
	private String mento_id;
	private Integer point;
	
	// select에 필요한 필드 추가매칭 
	private String artist_name;
	private String artist_birth;
	private String grade;
	private String mento_name;
	private Integer sum_point;
	private Float avg_point;
	private Integer rank;
}
