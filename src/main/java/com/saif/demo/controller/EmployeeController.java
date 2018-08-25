package com.saif.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.saif.demo.model.Employee;
import com.saif.demo.pojo.APIResponse;
import com.saif.demo.service.EmployeeService;

@RestController
@RequestMapping(value = "api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "v1", method = RequestMethod.POST)
    private APIResponse createEmployee(@RequestBody Employee employee) {
        return new APIResponse(employeeService.createEmployee(employee));
    }

    @RequestMapping(value = "v1/{id}", method = RequestMethod.GET)
    private APIResponse findById(@PathVariable Integer id) {
        return new APIResponse(employeeService.getById(id));
    }

    @RequestMapping(value = "v2/{name}", method = RequestMethod.GET)
    private APIResponse findByNameInSolr(@PathVariable String name) {
        return new APIResponse(employeeService.findSolrEmployeeByName(name));
    }

    @RequestMapping(value = "v2/db/{name}", method = RequestMethod.GET)
    private APIResponse findByNameInDB(@PathVariable String name) {
        return new APIResponse(employeeService.findDbEmployeeByName(name));
    }

}
