package model.domain.entity;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
@Builder

@Entity
public class Emp {
	@Id
	private Long empno;
	
	@NonNull
	@Column(length = 40,  nullable = false)
	private String ename;
	
	@NonNull
	@Column(length = 40,  nullable = false)
	private String job;
	
	private Long mgr;
	
	@NonNull
	@Column(name ="hiredate", nullable = false)
	private Date hdate;
	
	@NonNull
	@Column(nullable = false)
	private Long sal;
	
	private Long comm;
	
	@NonNull
	@ManyToOne
	@JoinColumn(name="deptno")
	private Dept deptno;
	
	@Override
    public String toString() {
        return "Emp{" +
                "empno=" + empno +
                ", ename='" + ename + '\'' +
                ", job='" + job + '\'' +
                ", mgr=" + mgr +
                ", hdate=" + hdate +
                ", sal=" + sal +
                ", comm=" + comm +
                '}';
    }
}