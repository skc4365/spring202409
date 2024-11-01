package com.skc;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.skc.dto.InjectionDTO;
import com.skc.repository.InjectionRepository;

@SpringBootTest
//@Transactional
public class InjectionTest {
	/*
	 * @SpringBootTest 스프링부트 전체 테스트코드를 실행하겠다.
	 * 
	 * @Transactional : 데이터소스 접근 query ROLL BACK기능 : 쿼리의 기능만 테스트하고 값을 초기화하는 용도.
	 */

	@Autowired
	InjectionRepository repo;

	@Test
	@DisplayName("지문0: 값의포함")
	void 기본테스트() {
		// given
		String strReq = "메소드별로 단위테스트를 할 수 있다.";
		String strRespon = "단위테스트 수행 확인은 정답(초록), 오답(빨강)";

		// when
		System.out.println("-----------------------------");
		System.out.println(strReq);
		System.out.println("-----------------------------");
		System.out.println(strRespon);
		System.out.println("-----------------------------");

		// then
		/*
		 * assertThat : 다음 문장이 정답이라고 주장한다. 정답(초록), 오답(빨강)
		 */
		assertThat(strReq).contains("단위테스트");
		assertThat(strRespon).contains("정답(초록), 오답(빨강)");
	}

//	@Test
//	@DisplayName("지문1: 백신테이블 기본데이터 확인.")
//	void 백신테이블select() {
//
//		// 'A001', '코로나', '10',
//		// 'A002', 'A형간염', '15'
//
//		// given
//		Integer row = 1;
//		List<InjectionDTO> list = repo.findAll();
//
//		// when
//		System.out.println("-----------------------------");
//		System.out.println("=====" + list.size() + "행");
//		System.out.println(
//				"=====" + list.get(row).getI_code() + " = " + list.get(row).getI_name() + " = " + list.get(row).getI_cnt());
//		System.out.println("-----------------------------");
//
//		// then
//		 //assertThat(list.size()).isEqualTo(2);
//		assertThat(list.get(row).getI_name()).contains("간");
//	}

//	@Test
//	@DisplayName("지문2: 백신테이블 정보입력 및 확인.")
//	void 백신테이블insert() {
//		// given
//		InjectionDTO ent = new InjectionDTO();
//		ent.setI_code("A004");
//		ent.setI_name("44바이러스");
//		ent.setI_age("19");
// 
//
//		int result = repo.save(ent);
//
//		// when
//		System.out.println("**********");
//		System.out.println("result : [" + result + "]");
//
//		//백신테이블select();
//		System.out.println("**********");
//		
//		//then
//		assertThat(result>0);
////		assertThat(list.size()).isEqualTo(3);
//	}

//	@Test
//	@DisplayName("지문3: 백신테이블 findById 확인")
//	void 백신테이블selectOne() {
//		// given
//		String str = "A003";
//
//		InjectionDTO ent = repo.findById(str);
//
//		// when
//		System.out.println("One 코드값:" + ent.getI_code());
//		System.out.println("One 코드값:" + ent.getI_name());
//		System.out.println("One 코드값:" + ent.getI_age());
//
//		// then
//		assertThat(ent.getI_name()).isEqualTo("B3바이러스");
//
//	}

//	@Test
//	@DisplayName("백신테이블 수정 및 확인")
//	void 백신테이블update() {
//		// given
//		InjectionDTO ent = repo.findById("A004");
//		ent.setI_name("C형간염");
//		ent.setI_age("25");
//
//		int result = repo.update(ent);
//		System.out.println("result== " + result);
//
//		// when
//		InjectionDTO ent2 = repo.findById("A004");
//		System.out.println("25C형간염== " + ent2.getI_name());
//
//		// then
//		assertThat(ent2.getI_age()).hasToString("25");
//	}

//	@Test
//	@DisplayName("백신테이블 삭제 및 확인")
//	void 백신테이블Delete() {
//		//given
//		int result = repo.deleteById("A003");
//		System.out.println(result);
//		List<InjectionDTO> list = repo.findAll();
//		//when
//		System.out.println("==" + list.get(1).getI_name());
//		System.out.println("==" + list.size());
//		
//		//then
//		// 0,1, 2개
//		//assertThat(list.size()).isEqualTo(2);
//		assertThat(list.get(0).getI_name()).contains("코로나");
//	}
}
