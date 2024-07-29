/* JPA 필수 적용 사항
 * 	- DTO는 view에서도 사용 가능한 데이터 표현용 클래스
 * 	- Model에서 생성해서 View에 전송
 * 
 * 	- JPA 특화된 클래스 : Entity 클래스
 * 	- RDBMS 자체의 table에 특화된 종속된 자바 클래스
 * 	- 구조 : table과 동일
 * 	- Entity는 객체 생성등 db와 완전 밀착
 * 		- setXxx() - update sql문장과 동일하게 수행
 * 	- Model단의 DB연동 로직에서만 사용해야 함
 * 
 * 	- DTO와 Entity가 같다..? 그럼 하나로 사용하면 안되나? 안된다.!.!.!
 * 
 */
package model.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class Dept01DTO {
	private int deptno;
	private String dname;
	private String loc;

}
