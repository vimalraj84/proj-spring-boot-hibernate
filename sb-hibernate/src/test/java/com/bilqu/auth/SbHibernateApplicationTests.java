package com.bilqu.auth;

import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bilqu.jpa.EmployeeService;
import com.bilqu.jpa.eo.Employee;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SbHibernateApplicationTests {

	
	@Autowired
    private EmployeeService empService;
 
	@Test
	public void contextLoads() {
		  List<Employee> emps = empService.getAll();
		  
	        assertNotNull(emps);
	        assertEquals(emps.size(), 2);
	}

}
