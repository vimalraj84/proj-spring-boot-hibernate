package com.bilqu.jpa.eo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import org.hibernate.envers.Audited;

@Entity
@Audited //will enable auditing/tracking changes on this EO
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "deptId")
public class Department extends AbstractEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long deptId;

	@Column(nullable = false)
	private String name;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "department")
	@OrderBy("empId asc")
	private List<Employee> employees;


	public Department() {
	}

	public Department(long id, String name) {
		this.deptId = id;
		this.name = name;
	}

	public Long getDeptId() {
		return deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return String.format("Department [deptId=%s, name=%s, employees=%s]", deptId, name, employees);
	}

}
