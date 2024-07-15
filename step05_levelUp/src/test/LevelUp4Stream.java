package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.domain.Customer;

public class LevelUp4Stream {

	public static void main(String[] args) {
		List<String> datas = Arrays.asList("a","b","c","d","e");
		List<String> datas2 = Arrays.asList("aa","b","cccc","dddddd","eeeeeee");
		//step01
		//더블 연산자 + forEach() 활용해서 출력해보기
		System.out.println("---- step01 ----");
		datas.forEach(v ->System.out.println(v));
		datas.forEach(System.out::println);
		
		//step02 - "b" 문자열 제외(조건)하고 출력
		datas.forEach((v) ->{System.out.println(v);});
		
		System.out.println("---- step02 ----");
		datas.forEach(v -> {
			if(!v.equals("b")) { //객체들의 내용 값 비교 메소드
				System.out.println(v);
			}
		});
		
		//step03 - Stream API 활용한 조건 표현
		System.out.println("---- step03 ----");
		datas.stream().filter(v -> !v.equals("b")).forEach(System.out::println);
		
		//step04 - String data 문자열 길이가 1인 경우 제외하고 데이터
		//List<String> datas2 = Arrays.asList("aa","b","cccc","dddddd","eeeeeee");
		System.out.println("---- step04 ----");
		datas2.stream().filter(v -> !(v.length()==1)).forEach(System.out::println);
		
		System.out.println("---- step04-1 ----");
		// String data 문자열 길이가 1인 경우 제외하고 문자열 길이 출력
		datas2.stream().filter(v -> !(v.length()==1)).forEach(v -> System.out.println(v.length()));
		
		//step05 - 사용자 정의 객체 타입(참조타입, 클래스타입) 활용
		System.out.println("---- step05 ----");
		ArrayList<Customer> al1 = new ArrayList<>();
		al1.add(new Customer("id1", "pw1"));
		al1.add(new Customer("id2", "pw2"));
		al1.add(new Customer("id3", "pw3"));
		// id2만 제외한 다른 고객의 id값만 출력
		al1.stream().filter(v -> !(v.getId().equals("id2"))).forEach(v -> System.out.println(v.getId()));
		
		//step06 - 연산
		//int v = Integer.parseInt("1");
		System.out.println("---- step06 ----");
		List<String> datas3 = Arrays.asList("1", "2", "3", "4", "5");
		
		int result = datas3.stream().mapToInt(Integer::parseInt).sum(); //mapToInt int값으로 매핑하겠다
		
		System.out.println(result);//15
		
		double result2 = datas3.stream().mapToDouble(Double::parseDouble).sum(); //mapToDouble double값으로 매핑하겠다
		System.out.println(result2);//15.0
		//List<String> datas3 = Arrays.asList("1", "2", "3", "4", "5");
		System.out.println(datas3.stream().mapToInt(Integer::parseInt).max()); //OptionalInt[5]
		
		System.out.println(datas3.stream().mapToInt(Integer::parseInt).count()); //5
		
		System.out.println(datas3.stream().mapToInt(Integer::parseInt).min().getAsInt()); //1
		
		
	}

}
