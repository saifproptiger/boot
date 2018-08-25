package com.saif.demo.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.saif.demo.pojo.BaseModel;

@Entity
@Table(name = "departments")
@JsonInclude(Include.NON_EMPTY)
public class Department extends BaseModel {

    private static final long serialVersionUID = 7417728813892703016L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer           id;

    @Column(name = "name")
    private String            name;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "department_id")
    private Set<Employee>     employees;

    @Transient
    private Set<Integer>      employeeIds;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public Set<Integer> getEmployeeIds() {
        return employeeIds;
    }

    public void setEmployeeIds(Set<Integer> employeeIds) {
        this.employeeIds = employeeIds;
    }

}
