package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.domain.Customer;

public class LevelUp5Optional {

	public static void main(String[] args) {
//		String s = null;
//		System.out.println(s.length()); null값이라 실행 예외 발생
		
		//step01
		System.out.println("---- step01 -----");
		List<String> datas1 = Arrays.asList("1", "2", "3", "4", "5", "3");
		List<String> datas2 = null;
		
		System.out.println(datas1.stream().mapToInt(Integer::parseInt).count()); //5
		
		System.out.println(datas1.stream().mapToInt(v -> {return Integer.parseInt(v);}).count()); //{}안에는 return이 필요하다 라는 걸 알 수 있음	
		
		System.out.println(datas1.stream().mapToInt(Integer::parseInt).filter(v -> v==3).count()); 	//그래서 조건을 붙이기 위해 filter를 구성한다. filter 순서도 한번 생각해볼만 함!
		System.out.println(datas1.stream().filter(v -> v.equals("3")).mapToInt(Integer::parseInt).count());  // filter 순서도 한번 생각해볼만 함!
		
		System.out.println(datas1.stream().filter(v -> v.equals("3")).mapToInt(Integer::parseInt).count());  // filter 순서도 한번 생각해볼만 함!
		
		//step02
		//3명의 고객 정보 생성
		//나이가 20 미만 고객들의 나이값 합산하기
		System.out.println("---- step02 -----");
		ArrayList<Customer> al1 = new ArrayList<>();
		al1.add(new Customer("id1", "pw1", 10, "상암", "VIP", "M"));
		al1.add(new Customer("id2", "pw2", 15, "마포", "gold", "F"));
		al1.add(new Customer("id3", "pw3", 50, "상암", "gold", "F"));
		System.out.println(al1.stream().filter(v -> (v.getAge() < 20)).mapToInt(Customer::getAge).sum());  // filter 순서도 한번 생각해볼만 함!
				
	}
}
