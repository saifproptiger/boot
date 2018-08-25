package com.saif.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saif.demo.model.Employee;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Integer> {

    List<Employee> findByName(String name);

}
