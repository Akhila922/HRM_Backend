package com.cg.hrms.service;

import com.cg.hrms.dto.EmployeeSummaryDto;
import com.cg.hrms.entity.Employee;
import java.util.List;

public interface EmployeeServiceVighnesh {
    List<Employee> getAllEmployees();
    Employee getEmployeeById(Long id);
    List<EmployeeSummaryDto> getEmployeeSummariesByCountry(String countryName);
}
