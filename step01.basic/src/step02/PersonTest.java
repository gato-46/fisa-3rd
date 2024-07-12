package step02;

import org.junit.Test;
import model.domain.Person;

public class PersonTest {
	@Test
	public void m1() {
		//? person 기본 생성자로 객체 생성
		//객체 생성 new Person();
		Person p1 = Person.builder().build();
		
	}

}
