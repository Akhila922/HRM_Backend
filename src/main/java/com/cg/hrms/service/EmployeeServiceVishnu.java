package com.cg.hrms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.hrms.entity.Employee;
import com.cg.hrms.repositories.EmployeeRepositoryVishnu;
@Service
public class EmployeeServiceVishnu {
    private final EmployeeRepositoryVishnu employeeRepository;

    public EmployeeServiceVishnu(EmployeeRepositoryVishnu employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getEmployeesByJobId(String jobId) {
        return employeeRepository.findByJob_JobId(jobId);
    }
}