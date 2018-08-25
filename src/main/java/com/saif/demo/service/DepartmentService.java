package com.saif.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saif.demo.exception.BadRequestException;
import com.saif.demo.model.Department;
import com.saif.demo.repo.DepartmentDao;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentDao departmentDao;

    public Department createDepartment(Department Department) {
        return departmentDao.save(Department);
    }

    public Department getById(Integer id) {
        return departmentDao.findById(id)
                .orElseThrow(() -> new BadRequestException("Department not found with id: " + id));
    }

}
