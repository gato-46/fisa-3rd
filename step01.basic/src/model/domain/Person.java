package model.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Person {
	private String id;
	private int pw;
	private String address;
	
	//Person(String id, int pw, String address){}
	

}
