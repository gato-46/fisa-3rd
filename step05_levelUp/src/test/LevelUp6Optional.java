package test;

import java.lang.StackWalker.Option;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

import org.junit.Test;

import model.domain.Customer;

public class LevelUp6Optional {
	
	/* 프로그램 실행 중지를 방지하기 위한 처리 코드는 어떻게?
	 * int sum = map.values().stream().filter(c -> (c.getAge() < 20)).mapToInt(Customer::getAge).sum();
	 */
//	@Test
	public void step08() {
		HashMap<String,Customer> map = null;
		Optional<HashMap<String, Customer>> opt = Optional.ofNullable(map);
		System.out.println("1-----------");		
		System.out.println("2-----------");
		opt.ifPresent(map2 -> {
			System.out.println(
			map2.values().stream().filter(customer -> (customer.getAge() < 20)).
			mapToInt(Customer::getAge).
			sum()
			);
		});
		System.out.println("3-----------");
	}
	
	@Test
	public void step081() {
		HashMap<String,Customer> map = new HashMap<>();
		map.put("id1", new Customer("id1", "pw1", 10, "상암", "VIP", "M"));
		map.put("id2",new Customer("id2", "pw2", 15, "마포", "gold", "F"));
		map.put("id3",new Customer("id3", "pw3", 50, "상암", "gold", "F"));
		Optional<HashMap<String, Customer>> opt = Optional.ofNullable(map);
		System.out.println("1-----------");		
		System.out.println("2-----------");
		opt.ifPresent(map2 -> {
			System.out.println(
			map2.values().stream().filter(customer -> (customer.getAge() < 20)).
			mapToInt(Customer::getAge).
			sum()
			);
		});
		System.out.println("3-----------");
	}
	
//	@Test
	public void step07() {
//		String v = null;
		String v = "fisa";
		Optional<String> opt = Optional.ofNullable(v); 
		System.out.println("1----");
		System.out.println(opt.isEmpty()); //null인 경우 true
		System.out.println(opt.isPresent()); //null인 경우 false
		System.out.println(opt.orElse("null인 경우 출력 메세지"));
		opt.ifPresent(v2 -> System.out.println(v));
		System.out.println("2----정상실행 유지");
	}
	
	/* of() : null은 불허, 실행시 예외 발생
	 * 		ifPresent() 불필요
	 * 
	 */
//	@Test
	public void step06() {
//		String v = null;
		String v = "fisa";
		Optional<String> opt = Optional.of(v); 
		System.out.println("1----");
		opt.ifPresent(v2 -> System.out.println(v));
		System.out.println("2----");
	}
	
	/* ofNullable : null 또는 실제객체로 생성
	 * 단, null 필터링은 ifPresent 활용도 가능
	 * ifPresent
	 * 	- Optional 객체 내부에 null이면 실행 skip
	 *  - null이 아닌 경우 실행
	 */
//	@Test
	public void step05() {
//		String v = null;
		String v = "fisa";
		Optional<String> opt = Optional.ofNullable(v);
		System.out.println("1----");
		opt.ifPresent(v2 -> System.out.println(v)); //ifPresent로 null인지 검증
		System.out.println("2----");
	}
	
	
	/* ofNullable() - null과 객체 다 수용
	 * get() - 실제 Optional 객체에 저장된 데이터값 반환 메소드
	 * 		- empty인 경우 실행 예외 발생
	 */
	
//	@Test
	public void step04() {
		String v = null; //Optional.empty
//		String v = "fisa"; //Optional[fisa]
		Optional<String> opt = Optional.ofNullable(v);
		System.out.println(opt.get());
	}
	
//	@Test //step02 실행 문제 해결, 기본 처리 방식
	public void step03() {
		String v = null;

		if(v != null) {
			System.out.println(v.length());
		}
		
	}
	
//	@Test
	public void step02() {
		String v =null;
		System.out.println(v.length()); //실행시 NullPointException 발생
		
	}
	
	public void step01() {
		//고유한 index로 데이터 관리
		ArrayList<Customer> al1 = new ArrayList<>();
		al1.add(new Customer("id1", "pw1", 10, "상암", "VIP", "M"));
		al1.add(new Customer("id2", "pw2", 15, "마포", "gold", "F"));
		al1.add(new Customer("id3", "pw3", 50, "상암", "gold", "F"));
		
		//고유한 구분값(key)값으로 데이터(value) 구분해서 사용 - map
		//String 타입의 key값으로 Customer객체들 구분
		//key는 중복 불허(id or email or 휴대폰번호..)
		/* 고려사항
		 * 1. 실데이터가 없을수도?
		 * 2. 실데이터 저장 공간인 list 또는 map 메모리가 없을수도?
		 * 		- 변수만 선언된 상태
		 * 
		 */
		
		HashMap<String, Customer> map = new HashMap<>();
		map.put("id1", new Customer("id1", "pw1", 10, "상암", "VIP", "M"));
		map.put("id2", new Customer("id2", "pw2", 15, "마포", "gold", "F"));
		map.put("id3", new Customer("id3", "pw3", 50, "상암", "gold", "F"));
		
		map.forEach((k,v) -> System.out.println(k + " " + v));
		
		System.out.println(" ---- ----");
		//map에 저장된 모든 고객의 나이값 합 출력
		map.forEach((k,v) -> System.out.println(v.getAge()));
		//map에 저장된 20미만의 나이값의 합 출력
		//Customer -> age 차출 -> 조건비교 -> 20미만 데이터
		//현 데이터 수이외에 다수의 데이터 존재할 경우라 가정
		map.forEach((k,v) -> { System.out.println(v.getAge());});
		System.out.println(" ---- ----");
		int sum = map.values().stream().filter(c -> (c.getAge()<20)).mapToInt(Customer::getAge).sum();
		System.out.println(sum);
	}

}
