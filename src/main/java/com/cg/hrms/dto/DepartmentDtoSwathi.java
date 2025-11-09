package com.cg.hrms.dto;

import java.util.List;

public class DepartmentDtoSwathi {
    private String departmentName;
    private List<EmployeeDtoSwathi> employees;

    public String getDepartmentName() { return departmentName; }
    public void setDepartmentName(String departmentName) { this.departmentName = departmentName; }

    public List<EmployeeDtoSwathi> getEmployees() { return employees; }
    public void setEmployees(List<EmployeeDtoSwathi> employees) { this.employees = employees; }
}