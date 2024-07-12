package step01;

public class BasicSyntax3 {
	// static : 메모리에 name 변수를 실체화 하는 객체 생성 작업 없이도 호출 가능
	/* static 키워드가 선언된 변수가 실제 생성되는 시점?
	 * 	- 실행 명령어가 시작하자마자 class byte code 메모리에 저장(적재, 로딩)
	 * 	- 로딩시 자동 생성
	 * 	- 객체생성시 별도의 name 변수 공간 생성하지 않음
	 * 
	 * non-static 변수들은 객체 생성시에 메모리에 생성
	 * 
	 */
	static String name = "상민"; // 생성되는 모든 객체가 공유
	int age = 21;
	
	static int no1 = 0;
	int no2 = 0;
	
	BasicSyntax3() {
		no1 = no1+1;
		no2 = no2+1;
	}
	
	static void info() {
		String name2 = "동길";
		int age2 = 22;
		System.out.println(name + " " + name2);
	}
	
	public static void main(String[] args) {
		info(); //현 코드가 구현된 구현된 클래스 내에서 static 메소드 검색해서 호출
		BasicSyntax3.info();// 외부에서 호출하는 static 메소드 호출하는 방법
		
		
		// step02 - static 변수와 non-static 변수 차이점 보기
		BasicSyntax3 bs1 = new BasicSyntax3(); 
		BasicSyntax3 bs2 = new BasicSyntax3(); 
		System.out.println(bs1.no1 + " " + no1);
		System.out.println(bs2.no1 + " " + no1);
		System.out.println(bs1.no2 + " " + bs2.no2);

		
//		BasicSyntax3 c = new BasicSyntax3(); 
//		System.out.println(c); 
//	    System.out.println(c.name);
//		c.info();
//		
//		name = "fisaman";
//		System.out.println(name);
		
		//API활용
		/* Math 데이터가 중요한게 아니라 max값 산출하는 메소드 기능
		 * API 설계자 자체도 사용자들이 주는 값 받고 비교하고 반환하고
		 * 즉 Math 객체 생성할 이유가 없어서 static으로 제시 
		 */
		int v1 = Math.max(10,20);
		System.out.println(v1);
		
		/* String - jdk 내부에 클래스
		 * 클래스 - 변수, 생성자, 메소드
		 * 문자열로 데이터 - 문자열 객체 생성 " " 표기만으로 자동으로 객체 생성
		 * 1. 문자열 길이 카운팅 기능
		 * 	- length / 문자열 값 필요 / int 반환
		 * 
		 * 2. 문자열의 특정 위치 글자 하나만 착출해서 반환
		 * 	- charAt / 문자열과 한글자 위치(int) / 하나의 char 반환
		 * 
		 * 3. 이미 존재하는 문자열에 새로운 문자열 받아서 결합해서 반환
		 * 	- ? / 문자열과 새로 받는 데이터(string) / 문자열(string) 하나 반환
		 * 
		 */

	}

}