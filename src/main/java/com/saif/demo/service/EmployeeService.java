package com.saif.demo.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.saif.demo.exception.BadRequestException;
import com.saif.demo.model.Employee;
import com.saif.demo.model.solr.SolrEmployee;
import com.saif.demo.repo.EmployeeDao;
import com.saif.demo.solr.service.EmployeeSolrIndexingService;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDao                 employeeDao;

    private EmployeeSolrIndexingService employeeSolrIndexingService;

    @Autowired
    private ApplicationContext          applicationContext;

    @PostConstruct
    public void init() {
        if (employeeSolrIndexingService == null) {
            employeeSolrIndexingService = applicationContext.getBean(EmployeeSolrIndexingService.class);
        }
    }

    public List<Employee> findSolrEmployeeByName(String name) {
        return employeeSolrIndexingService.findByName(name).stream().map(SolrEmployee::getEmployee)
                .collect(Collectors.toList());
    }

    @Cacheable(cacheNames = "employee")
    public List<Employee> findDbEmployeeByName(String name) {
        return employeeDao.findByName(name);
    }

    public Employee createEmployee(Employee employee) {
        return employeeDao.save(employee);
    }

    public Employee getById(Integer id) {
        return employeeDao.findById(id).orElseThrow(() -> new BadRequestException("Employee not found with id: " + id));
    }

    public List<Employee> findByIdIn(Set<Integer> employeeIds) {
        if (CollectionUtils.isEmpty(employeeIds)) {
            return employeeDao.findAll();
        }
        return employeeDao.findAllById(employeeIds);
    }

}
