package com.bilqu.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;
import org.springframework.stereotype.Repository;

import com.bilqu.jpa.eo.Department;

@Repository
public interface ContactRepositoy extends JpaRepository<Department, Long>, RevisionRepository<Department, Long, Long> {

}
