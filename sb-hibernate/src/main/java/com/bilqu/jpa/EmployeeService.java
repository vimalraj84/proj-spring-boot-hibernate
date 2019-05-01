package com.bilqu.jpa;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bilqu.jpa.dao.DepartmentRepositoy;
import com.bilqu.jpa.dao.EmployeeRepositoy;
import com.bilqu.jpa.eo.Department;
import com.bilqu.jpa.eo.Employee;

@RestController
public class EmployeeService {

	@Autowired
	private EmployeeRepositoy empRepo;

	@Autowired
	private DepartmentRepositoy deptRepo;

	@GetMapping("getEmp/id/{id}")
	public @ResponseBody Optional<Employee> getById(@PathVariable("id") long id) {
		return empRepo.findById(id);
	}

	@GetMapping("getOneEmp/id/{id}")
	public @ResponseBody  Employee getOneEmp(@PathVariable("id") long id) {
		return empRepo.getOne(id);
	}

	@GetMapping("getAllEmp")
	public @ResponseBody  List<Employee> getAll() {
		List<Employee> employees = empRepo.findAll();
		//		System.out.println(employees);
		return employees;
	}

	@GetMapping("getAllDept")
	public @ResponseBody List<Department> getAllDept() {
		List<Department> departments = deptRepo.findAll();
		//		System.out.println(departments);
		return departments;
	}

	@GetMapping("getEmpByDept/deptId/{deptId}")
	public @ResponseBody List<Employee> getEmpByDept(@PathVariable("deptId") long deptId) {
		return empRepo.findByDepartment(new Department(deptId));
	}

	@GetMapping("getDepartmentByEmp/empId/{empId}")
	public @ResponseBody Department getDepartmentByEmp(@PathVariable("empId") long empId) {
		return deptRepo.findByEmployee(new Employee(empId));
	}

	@Transactional
	@PutMapping("addEmp")
	public @ResponseBody Employee addEmp(@RequestBody Employee employee) {
		return empRepo.save(employee);
	}

	@Transactional
	@PostMapping("updateEmp")
	public @ResponseBody Employee updateEmp(@RequestBody Employee employee) {
		return empRepo.save(employee);
	}

	@Transactional
	@PutMapping("addDept")
	public @ResponseBody Department addDept(@RequestBody Department department) {
		return deptRepo.save(department);
	}

	@Transactional
	@PostMapping("updateDept")
	public @ResponseBody Department updateDept(@RequestBody Department department) {
		return deptRepo.save(department);
	}


}
