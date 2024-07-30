package running;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.Test;

import model.domain.entity.Customer;
import model.domain.entity.Dept;
import util.DBUtil;

public class RunningTest {
	
	//step04
	/* dept entity 개발 -> 설정 파일에 등록 -> 모든 부서 검색해서 출력
	 * JPA만의 select 문장
	 * 	- JPA는 entity를 기반으로 rdbms의 table과 소통
	 * 	- select entity멤버변수들 from entity명
	 * 	- select d from Dept d;
	 * 	 - Dept entity의 모든 내용 검색(모든 멤버 변수)
	 * 		: rdbms로 select + * from dept; 문장으로 처리
	 * 					select dname from dept;
	 * 					-> JPA의 select 문장으로 변환시
	 * 						select d.dname from Dept d;
	 * 							d : 참조변수를 간주
	 * 							d.dname : d가 참조하는 객체의 dname 멤버 변수명 호출
	 */
	@Test
	public void step04() {
		EntityManager em = DBUtil.getEntityManager();
		List<Dept> datas = em.createQuery("select d from Dept d", Dept.class).getResultList();	
		System.out.println(datas.size());
		
		//stream api + rambda 식을 출력
		datas.forEach(System.out::println);
		
		//모든 부서번호의 합 출력
		int deptnoSum = em.createQuery("select d from Dept d", Dept.class).getResultStream().mapToInt(Dept::getDeptno).sum();
		System.out.println("모든 부서 번호의 합" + deptnoSum);
		
		//부서 번호가 40미만인 부서번호들만 합을 구하기
		int deptnoSum1 = em.createQuery("select d from Dept d", Dept.class).getResultStream().mapToInt(Dept::getDeptno).filter(deptno -> deptno < 40).sum();
		System.out.println("40미만 부서 번호의 합" + deptnoSum1);
		
		em.close();
}
	

// step01 table 생성, 
	// @Test
	public void step01() {

		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		em.persist(new Customer("id14", "연아", 50)); // no가 1로 저장되어 있음

		Customer c1 = em.find(Customer.class, 1);
		System.out.println(c1);

		c1.setName("유다연"); // update Customer set age=?, id=?, fisaname=? where no=?
		tx.commit();

		em.close();
	}

// step02 - 저장 시도는 하나 commit 안 함 단, 검색, setXxx()로 수정시도
//		@Test
	public void step02() {

		EntityManager em = DBUtil.getEntityManager();

		em.persist(new Customer("id2", "연아", 50)); // no가 2로 저장되어 있음

//			Customer c1 = em.find(Customer.class, 2); //no가 2인 데이터 검색
		/*
		 * persistent context 라는 영속성(데이터) 저장소에 없다. -> db에 select해서 검색된 데이터인 entity객체를
		 * paristent context에 저장해 놓음
		 */

		Customer c1 = em.find(Customer.class, 1); // select
		System.out.println("-1-" + c1); // -1- null

		c1.setName("박지오");
		System.out.println("-2-" + c1);

		/*
		 * persistent context 라는 영속성(데이터) 저장소에 1 pk의 entity가 있다. db에 select 할 필요가 없다. if
		 * c1 = em.find(Customer.class, 10)으로 하면 2번 select가 된다
		 */
		c1 = em.find(Customer.class, 1);
		System.out.println("-3-" + c1);

		em.close();
	}

//step03 
	/*
	 * 존재하는 customer에 검색 -> 수정 -> 검색 -> 삭제
	 */
	//@Test
	public void step03() {
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();

		Customer c = em.find(Customer.class, 1);
		System.out.println(c);

		c = em.find(Customer.class, 1);
		System.out.println(c);

		tx.begin();
		c.setAge(20); // update 준비(DB에 영구 적용 직전, 영속성 영역에 이미 반영)
		em.remove(c); // persistence context의 내용도 삭제 의미 + delete 문장 생성(DB에 영구 적용 직전, 영속성 영역에 이미 반영)
		em.clear(); // persistent context 잔존된 정보를 삭제하는 메소드
		c = em.find(Customer.class, 1); // pk(1)값으로 하나만 검색
		System.out.println(c); // commit() : null값 출력, non-commit() : null값 출력
		// tx.commit(); //db에 update와 delete 수행

		em.close();
	}

}