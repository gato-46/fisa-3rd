package step01;

public class Test {
	
	static int no1 = 0;
	int no2 = 0;
	static int no3 = 0;
	
	Test() {
		no1 = no1+1;
		no2 = no2+1;
		no3 = no1+no2;
	}
	
	public static void main(String[] args) {
		Test t1 = new Test();
		System.out.println(no1 + " " + t1.no2);
		int no2 = 13;
		Test t2 = new Test();
		System.out.println(no1 + " " + no2);
		int no1 = 12;
		System.out.println(no1 + " " + no3);
		Test t3 = new Test();
		System.out.println(no3);
		
	}

}
