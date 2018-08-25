package com.saif.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.saif.demo.model.Department;
import com.saif.demo.pojo.APIResponse;
import com.saif.demo.service.DepartmentService;

@RestController
@RequestMapping(value = "api/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping(value = "v1", method = RequestMethod.POST)
    private APIResponse createDepartment(@RequestBody Department department) {
        return new APIResponse(departmentService.createDepartment(department));
    }

    @RequestMapping(value = "v1/{id}", method = RequestMethod.GET)
    private APIResponse findById(@PathVariable Integer id) {
        return new APIResponse(departmentService.getById(id));
    }

}
