package com.bilqu.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;
import org.springframework.stereotype.Repository;

import com.bilqu.jpa.eo.Employee;

//Employee is the entity that is being managed and the primary key of Employee is Long.

@Repository
public interface EmployeeRepositoy extends JpaRepository<Employee, Long>,RevisionRepository<Employee, Long, Long> {

	// List<Employee> findByDeptId(long id);
}
