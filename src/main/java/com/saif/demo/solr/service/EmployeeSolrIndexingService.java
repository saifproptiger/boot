package com.saif.demo.solr.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.saif.demo.model.Employee;
import com.saif.demo.model.solr.SolrEmployee;
import com.saif.demo.service.EmployeeService;
import com.saif.demo.solr.enums.SolrDocumentType;
import com.saif.demo.solr.repo.EmployeeSolrDao;

@Service
public class EmployeeSolrIndexingService {

    private EmployeeService    employeeService;

    @Autowired
    private EmployeeSolrDao    employeeSolrDao;

    @Autowired
    private ApplicationContext applicationContext;

    @PostConstruct
    public void init() {
        if (employeeService == null) {
            employeeService = applicationContext.getBean(EmployeeService.class);
        }
    }

    @Cacheable(cacheNames = "employee")
    public List<SolrEmployee> findByName(String name) {
        List<SolrEmployee> solrEmployees = employeeSolrDao.findByEmployeeName(name);
        return solrEmployees;
    }

    public List<Employee> indexEmployee(Set<Integer> employeeIds) {
        return employeeService.findByIdIn(employeeIds).stream().map(e -> indexOneEmployee(e))
                .map(SolrEmployee::getEmployee).collect(Collectors.toList());
    }

    private SolrEmployee indexOneEmployee(Employee employee) {
        return employeeSolrDao.save(convertToSolrEmployee(employee));
    }

    private SolrEmployee convertToSolrEmployee(Employee employee) {
        SolrEmployee solrEmployee = new SolrEmployee();
        solrEmployee.setDocumentType(SolrDocumentType.EMPLOYEE);
        solrEmployee.setEmployeeId(employee.getId());
        solrEmployee.setEmployeeName(employee.getName());
        solrEmployee.setEmployeeAge(employee.getAge());
        solrEmployee.setEmployeeUsername(employee.getUsername());
        solrEmployee.setEmployeeDepartmentId(employee.getDepartmentId());
        solrEmployee.setEmployeeDepartmentName("Dummy Department Name");
        solrEmployee.prePersist();
        return solrEmployee;
    }

}
