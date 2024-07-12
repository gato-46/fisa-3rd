/* 학습내용
 * 
 * 1. 주목적 : 타인 개발 코드 분석의 용이, API 활용 역량 강화
 * 
 */

package step02;

import org.junit.Test;

class A {
	String message = "fisa3기";// String 객체
	int no = 10;
	StringBuffer msg2 = new StringBuffer("새로운 문자타입");

	A() {
		System.out.println("A 객체 생성");
	}// String 객체 생성 -> A 객체 생성 후
}

class B {
	A a = new A();// A타입의 데이터,사용자 정의 타입

	B() {
		System.out.println("B 객체 생성");
	}
}

class C {
	B b = new B();

	C() {
		System.out.println("C 객체 생성");
	}// 보유한 멤버가 완벽하게 메모리에 생성후 종료
}

public class ApplyTest {
	@Test
	public void lab() {
		C c = new C();
		/*
		 * 더이상의 객체 생성 불가 new 생성자호출 불가 ? 
		 * 1. 생성되는 객체 수 몇개? String A B C 4개
		 * 2. 생성되는 객체 순서는? + 확인은 어떻게? C B A
		 * 3. A의 message 변수값 출력 System.out.println(c.b.a.message);
		 */
		
		/*
		 * String 타입의 객체들은 불변 객체 이미 생성된 String 객체의 메모리 데이터는 업데이트 불가 
		 * 	- 조금이라도 수정되는 문자열이있다? 무조건 메모리에 새로 생성 
		 * StringBuffer 타입의 객체들 이미 생성된 메모리의 문자열 데이터 업데이트 가능
		 */
		String v = c.b.a.message;
		System.out.println(v); // fisa3기

		c.b.a.message = "상암";
		System.out.println(c.b.a.message);// 상암
		System.out.println(v); // fisa3기

		System.out.println("****2***");
		int v2 = c.b.a.no; 
		System.out.println(v2);// 10
		c.b.a.no = 3;
		System.out.println(c.b.a.no);// 3
		System.out.println(v2); // 10

		System.out.println("****3***");
		System.out.println(c.b.a.msg2);// 새로운 문자타입

		StringBuffer sb = c.b.a.msg2; // sb와 객체 모두 StringBuffer 참조
		System.out.println(sb); // 새로운 문자타입
		c.b.a.msg2.append(" new data"); 
		
		System.out.println(sb);// 새로운 문자타입 new data
		System.out.println(c.b.a.msg2);// 새로운 문자타입 new data
		System.out.println(sb); // 새로운 문자타입 new data

	}
}