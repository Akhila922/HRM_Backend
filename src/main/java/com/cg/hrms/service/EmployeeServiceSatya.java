package com.cg.hrms.service;

import java.util.List;

import com.cg.hrms.entity.Employee;

public interface EmployeeServiceSatya {
    List<Employee> getAllEmployees();

    List<Employee> getEmployeesByLocation(Long locationId);
}