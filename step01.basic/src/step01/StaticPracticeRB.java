package step01;

public class StaticPracticeRB {

	static String str1 = "jw";
	String str2 = "mil";
	static char a = 'a';
	
	StaticPracticeRB(){
		str2 = str1.concat("k");
		str1 = str1.concat(str2);
		a = str1.charAt(4);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StaticPracticeRB sp1 = new StaticPracticeRB(); 
		// str2<-jwk, str1<-jwjwk, a=k
		//str1은 static변수이기 때문에 메모리 메소드 영역에 할당되기 때문에 모든 인스턴스가 공유하는 특성을
		//가지기 때문에 str1은 jwjwk 값을 유지하게 됩니다. 
		StaticPracticeRB sp2 = new StaticPracticeRB();
		// str2 = jwjwjwkk, str1 = jwjwkjwjwkk, a = k
		System.out.println(str1);
		System.out.println(a);
		
		
	}

}