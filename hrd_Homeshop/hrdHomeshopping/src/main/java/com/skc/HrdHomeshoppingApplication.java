package com.skc;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HrdHomeshoppingApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrdHomeshoppingApplication.class, args);
	}

	// DB연결 테스트
	private static final Logger logger = LoggerFactory.getLogger(HrdHomeshoppingApplication.class);

	@Bean
	CommandLineRunner testDBCon(DataSource dataSource) {
		return arg -> {
			try {
				dataSource.getConnection().close();
				logger.info("^^^^^^ DataBase 연결 성공 ^^^^^^");
			} catch (Exception e) {
				logger.error("ㅠㅠㅠㅠㅠㅠ DataBase 연결 실패 ㅠㅠㅠㅠㅠㅠ", e);
			}
		};
	}

}
