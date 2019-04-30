package com.bilqu.jpa.eo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.envers.Audited;

//by default Hibernate will generate the names of the tables in lowercase letters.
//We could also try to explicitly set the table name, like this: @Entity(name="EMPLOYEE")
@Entity
@Audited //will enable auditing/tracking changes on this EO
public class Employee extends AbstractEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long empId;
	@Column(name = "NAME")
	private String name;
	@Column(name = "age")
	private int age;


	public Employee() {

	}

	public Employee(String name, int age) {
		this.name = name;
		this.age = age;
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

	@Override
	public String toString() {
		return String.format("Employee [id=%s, name=%s, age=%s]", empId, name, age);
	}
}
