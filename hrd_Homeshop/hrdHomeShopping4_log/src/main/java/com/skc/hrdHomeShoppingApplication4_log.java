package com.skc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class hrdHomeShoppingApplication4_log {

	public static void main(String[] args) {
		SpringApplication.run(hrdHomeShoppingApplication4_log.class, args);
	}
	
	// 순서1. DB연결 테스트를 위한 코드
//	private static final Logger logger = LoggerFactory.getLogger(ExHHomeShoppingApplication4_log.class);
//	
//	@Bean
//	CommandLineRunner testDBCon(DataSource dataSource) {
//		return arg -> {
//			try {
//				dataSource.getConnection().close();
//				logger.info("^^^^^^ DataBase 연결 성공 ^^^^^^");
//			} catch (Exception e) {
//				logger.error("ㅠㅠㅠㅠㅠㅠ DataBase 연결 실패 ㅠㅠㅠㅠㅠㅠ", e);
//			}
//		};
//	}
	
}
