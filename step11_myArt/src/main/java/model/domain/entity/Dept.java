package model.domain.entity;
import java.util.*;
import javax.persistence.*;
import lombok.*;
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
@Builder

@Entity
public class Dept {
	@Id
	private Long deptno;
	
	@NonNull
	@Column(length = 40,  nullable = false)
	private String dname;
	
	@NonNull
	@Column(length = 40,  nullable = false)
	private String loc;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "deptno")
    List<Emp> emps = new ArrayList<>();
}