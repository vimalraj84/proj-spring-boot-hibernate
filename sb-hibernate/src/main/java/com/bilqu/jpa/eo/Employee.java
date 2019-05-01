package com.bilqu.jpa.eo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;

import org.hibernate.envers.Audited;

//by default Hibernate will generate the names of the tables in lowercase letters.
//We could also try to explicitly set the table name, like this: @Entity(name="EMPLOYEE")
@Entity
@Audited //will enable auditing/tracking changes on this EO
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "empId")
public class Employee extends AbstractEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "emp_id_seq")
	@SequenceGenerator(name = "emp_id_seq", sequenceName = "EMP_ID_SEQ", initialValue = 1001)
	private Long empId;

	@Column(name = "NAME", nullable = false)
	private String name;

	@Column(name = "age", nullable = false)
	private int age;

	@Transient // Field is not persisted in the database
	private String comment;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "deptId", nullable = false)
	//	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Department department;


	public Employee() {

	}

	public Employee(Long id, String name, int age) {
		this.empId = id;
		this.name = name;
		this.age = age;
	}

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return String.format("Employee [empId=%s, name=%s, age=%s, department=%s]", empId, name, age, department);
	}

}
