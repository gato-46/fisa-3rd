/* 학습내용
 * 	- 상속 다양성 리뷰
 */

package step01.basic;

import model.domain.PeopleDTO;

    //step01
public class OOP2 {
	// Object o = new Parent();이랑 같은 의미, 자동 형변환(promotion)
	static Object m1() { // 반환시 Object인 상위 타입으로 자동형변환 되어 반환
		return new Parent(); // Object의 자식 객체 생성
	}

	// step02
	static Object[] m2() {
		Object[] o = new Object[3]; // Object는 모든 클래스 최상위 root
		o[0] = "str"; //문자열 생성 -> Object로 변환되면서 저장 Object o = "str";
		o[1] = 3;
		o[2] = new PeopleDTO("id", 11);

		return o;
	}
	


	public static void main(String[] args) {
//      step02
		// m2()호출
		Object[] c = m2();
		// index 0번쨰 문자열 길이 출력 / String타입으로 형변환해야 length()가능
		System.out.println(((String)c[0]).length());
		// index 2의 id값만 출력 - id는 상속받지 않은 PeopleDTO만의 멤버 변수
		System.out.println(((PeopleDTO)c[2]).getName());
		// index 2의 id값을 다른 name 값으로 수정
		((PeopleDTO)c[2]).setName("name");
		// index 2의 id값만 출력
		System.out.println(((PeopleDTO)c[2]).getName());
		
//      step01
//		Object 타입으로 반환, 자식타입의 변수엔 명시적인 형변환(typecasting)
//		Parent p = (Parent)m1();
//		p.id = "fisa man";
//		p.PrintAll();

	}

}