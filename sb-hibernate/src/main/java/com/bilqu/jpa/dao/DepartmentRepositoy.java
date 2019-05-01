package com.bilqu.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;
import org.springframework.stereotype.Repository;

import com.bilqu.jpa.eo.Department;
import com.bilqu.jpa.eo.Employee;

@Repository
public interface DepartmentRepositoy extends JpaRepository<Department, Long>,RevisionRepository<Department, Long, Long> {

	Department findByEmployee(Employee emp);

}
