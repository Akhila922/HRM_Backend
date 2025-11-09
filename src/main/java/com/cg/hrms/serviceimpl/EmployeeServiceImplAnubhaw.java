package com.cg.hrms.serviceimpl;

import com.cg.hrms.entity.Employee;
import com.cg.hrms.repositories.EmployeeRepositoryAnubhaw;
import com.cg.hrms.service.EmployeeServiceAnubhaw;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImplAnubhaw implements EmployeeServiceAnubhaw {

    private final EmployeeRepositoryAnubhaw employeeRepository;

    public EmployeeServiceImplAnubhaw(EmployeeRepositoryAnubhaw employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
}