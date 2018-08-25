package com.saif.demo.model.solr;

import java.util.Set;

import javax.persistence.PrePersist;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.saif.demo.model.Department;
import com.saif.demo.model.Employee;
import com.saif.demo.pojo.SolrBaseModel;
import com.saif.demo.solr.enums.SolrDocumentType;

@SolrDocument(collection = "collection_employee")
@JsonInclude(Include.NON_EMPTY)
public class SolrEmployee extends SolrBaseModel {

    private static final long serialVersionUID = -8278219333546332935L;

    private Employee          employee         = new Employee();

    private Department        department       = new Department();

    @Field("DOCUMENT_TYPE")
    @Indexed
    private SolrDocumentType  documentType;

    @Field("EMPLOYEE_ID")
    @Indexed
    private Integer           employeeId;

    @Field("EMPLOYEE_NAME")
    @Indexed
    private String            employeeName;

    @Field("EMPLOYEE_AGE")
    @Indexed
    private Integer           employeeAge;

    @Field("EMPLOYEE_USERNAME")
    @Indexed
    private String            employeeUsername;

    @Field("EMPLOYEE_DEPARTMENT_ID")
    @Indexed
    private Integer           employeeDepartmentId;

    @Field("EMPLOYEE_DEPARTMENT_NAME")
    @Indexed
    private String            employeeDepartmentName;

    @Field("DEPARTMENT_ID")
    @Indexed
    private Integer           departmentId;

    @Field("DEPARTMENT_NAME")
    @Indexed
    private String            departmentName;

    @Field("DEPARTMENT_EMPLOYEE_IDS")
    @Indexed
    private Set<Integer>      departmentEmployeeIds;

    @PrePersist
    @Override
    public void prePersist() {
        super.id = documentType.equals(SolrDocumentType.EMPLOYEE)
                ? documentType.name() + "-" + employeeId
                : documentType.name() + "-" + departmentId;
    }

    public Employee getEmployee() {
        employee.setId(employeeId);
        employee.setName(employeeName);
        employee.setAge(employeeAge);
        employee.setUsername(employeeUsername);
        employee.setDepartment(getDepartment());
        return employee;
    }

    public Department getDepartment() {
        department.setId(employeeDepartmentId == null ? departmentId : employeeDepartmentId);
        department.setName(employeeDepartmentName == null ? departmentName : employeeDepartmentName);
        department.setEmployeeIds(departmentEmployeeIds);
        return department;
    }

    @Field("EMPLOYEE_ID")
    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    @Field("EMPLOYEE_NAME")
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    @Field("EMPLOYEE_AGE")
    public void setEmployeeAge(Integer employeeAge) {
        this.employeeAge = employeeAge;
    }

    @Field("EMPLOYEE_USERNAME")
    public void setEmployeeUsername(String employeeUsername) {
        this.employeeUsername = employeeUsername;
    }

    @Field("EMPLOYEE_DEPARTMENT_ID")
    public void setEmployeeDepartmentId(Integer employeeDepartmentId) {
        this.employeeDepartmentId = employeeDepartmentId;
    }

    @Field("EMPLOYEE_DEPARTMENT_NAME")
    public void setEmployeeDepartmentName(String employeeDepartmentName) {
        this.employeeDepartmentName = employeeDepartmentName;
    }

    @Field("DEPARTMENT_ID")
    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
        department.setId(departmentId);
    }

    @Field("DEPARTMENT_NAME")
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Field("DEPARTMENT_EMPLOYEE_IDS")
    public void setDepartmentEmployeeIds(Set<Integer> departmentEmployeeIds) {
        this.departmentEmployeeIds = departmentEmployeeIds;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public SolrDocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(SolrDocumentType documentType) {
        this.documentType = documentType;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public Integer getEmployeeAge() {
        return employeeAge;
    }

    public String getEmployeeUsername() {
        return employeeUsername;
    }

    public Integer getEmployeeDepartmentId() {
        return employeeDepartmentId;
    }

    public String getEmployeeDepartmentName() {
        return employeeDepartmentName;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public Set<Integer> getDepartmentEmployeeIds() {
        return departmentEmployeeIds;
    }

}
