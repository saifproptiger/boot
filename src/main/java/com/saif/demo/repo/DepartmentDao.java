package com.saif.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saif.demo.model.Department;

@Repository
public interface DepartmentDao extends JpaRepository<Department, Integer> {

}
