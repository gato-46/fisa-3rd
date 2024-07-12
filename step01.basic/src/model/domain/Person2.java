package model.domain;


import org.junit.Test;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@NoArgsConstructor // 기본 생성자
@AllArgsConstructor // 모든 생성자
@RequiredArgsConstructor // 특정 생성자 @NonNull

public class Person2 {
	@NonNull //@NotNull - sql값 반드시 적용하란 설정
	private String id;
	private int pw;
	@NonNull
	private String address;

//	#step01 - 컴파일 정상, 실행 불가 왜? -> JUnit이 비추하는 구조
	/* 
	 @NoArgsConstructor 
	 @AllArgsConstructor 
	 @RequiredArgsConstructor 
	 */
	
//	@Test 
//	public void info() {
//		Person2 p1 = new Person2("username", "상암");
//	}
	// step02 - JUnit에선 실행 불가였으나 main메소드에선 실행
	public static void main(String [] args) {
		Person2 p2 = new Person2("username",10, "상암");
		System.out.println(p2.id);
	}
	
}
