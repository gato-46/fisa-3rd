/* 학습 내용
 * 1. 상속
 * 
 * 2. 용어
 * 	상속시키는 주체 : 부모 클래스/상위 클래스
 *  상복 받는 주체 : 자식 클래스/하위 클래스
 * 
 * 3. 클래스 구성
 * 	1. 기본 요소 : 변수 / 생성자 / 메소드
 * 	2. 상속 관계에선 자식이 상속 받는 요소 : 변수와 메소드
 * 		- 자식 클래스 관점에서 데이터 수정, 메소드 기능 편집(재정의, overriding, override)
 * 
 * 4. 원리
 * 	1. 모든 클래스의 최상위 root - java.lang.object
 *  2. 직계 부모 클래스는 하나
 *  3. 자식객체 생성시 부모 객체 생성이 우선 : supper 키워드
 * 
 */


package step01.basic;

class Parent extends Object{
	String id;
	int pw;
	
	public Parent() {
		super();
	}
	
	void PrintAll() {
		System.out.println(id);
		System.out.println(pw);
	}
}

class Child extends Parent { //Object -> Parent -> Child
	String grade;
	
	public Child() {
		super();
	}
	
	void PrintAll() {
		System.out.println(id);
		System.out.println(pw);
		System.out.println(grade);
	}
}

public class OOP1 extends Object{ //extends Object 안보여도 자동으로 만들어지
	public OOP1() { //자동으로 만들어짐
		super(); //()즉 argument 가 동일한 상위 클래스의 생성자 호출
	}

	public static void main(String[] args) {
		Child c = new Child(); // 모든 멤버 변수를 사용 가능하게 heap에 실체화, c는 Chidl()객체를 참조하는 변수, 타입은 Child
		// System.out.println(c.id);
		// 상속받은 메소드만 id/pw 값만 출력 -> Child 재정의 후 다 재정의된 메소드 출력
		c.PrintAll();
		//다형성 - 상속 관계가 전제조전
		Parent p = new Child(); //Child() 참조, Parent 타입
		p.id = "master";
    	//p.grade = "vvip"; error
		Child c2 = (Child)p; //객체 타입간의 명시적인 형 변환 문법, c객체가 아닌 p객체, p객체는 = c2객체
		c2.grade = "vvip";
		System.out.println("-----------");
		p.PrintAll();
		System.out.println("-----------");
		c2.PrintAll();	
		
	}

}