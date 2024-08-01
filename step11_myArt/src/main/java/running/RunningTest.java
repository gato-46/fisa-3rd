package running;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import model.domain.entity.Dept;
import model.domain.entity.Emp;
import org.junit.Test;
import java.util.Date;
import java.util.List;
import util.DBUtil;

public class RunningTest {
	
	// 특정 부서에 소속된 직원들의 이름 출력
	//@Test
	public void findEmpsTest() {
		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = DBUtil.getEntityManager();
			tx = em.getTransaction();
			tx.begin();

			Dept dept = em.find(Dept.class, 10L);

			// null 체크 추가
			if (dept != null) {
				dept.getEmps().forEach(
						e -> System.out.println(e.getEname()));
			}

			tx.commit();

		} catch (Exception e) {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}
	
	
	// 모든 직원을 조회하고 출력
	//@Test
	public void findAllEmpsTest() {
		EntityManager em = null;

		try {
			em = DBUtil.getEntityManager();
			List<Emp> emps = em.createQuery("SELECT e FROM Emp e", Emp.class).getResultList();
			for (Emp emp : emps) {
				System.out.println(emp.getEname());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}
	
	// 새로운 부서를 생성하고 데이터베이스에 저장
	//@Test
	public void createDeptTest() {
		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = DBUtil.getEntityManager();
			tx = em.getTransaction();
			tx.begin();
			
			Dept dept = Dept.builder()
	                .deptno(1234L)
	                .dname("교육부")
	                .loc("상암2")
	                .build();
			
			em.persist(dept);

			tx.commit();
		} catch (Exception e) {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	// 새로운 직원을 생성하고 기존 부서와 연관지어 데이터베이스에 저장
	//@Test
	public void createEmpTest() {
		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = DBUtil.getEntityManager();
			tx = em.getTransaction();
			tx.begin();

			Dept dept = em.find(Dept.class, 10L); // 기존 부서를 찾아와야 함

			Emp emp = Emp.builder()
		                .empno(10L) 
		                .ename("손흥민2")
		                .job("축구선수")
		                .hdate(new Date())
		                .sal(5000L)
		                .deptno(dept)
		                .build();
			
			em.persist(emp);
			
			tx.commit();
		} catch (Exception e) {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	
	// 직원의 정보를 업데이트
	//@Test
	public void updateEmpTest() {
		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = DBUtil.getEntityManager();
			tx = em.getTransaction();
			tx.begin();

			Emp emp = em.find(Emp.class, 10L); // 직원 ID를 찾아와야 함

			tx.commit();
		} catch (Exception e) {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	// 직원을 삭제
	//@Test
	public void deleteEmpTest() {
		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = DBUtil.getEntityManager();
			tx = em.getTransaction();
			tx.begin();

			Emp emp = em.find(Emp.class, 1L); // 직원 ID를 찾아와야 함
			if (emp != null) {
				em.remove(emp);
			}

			tx.commit();
		} catch (Exception e) {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

}