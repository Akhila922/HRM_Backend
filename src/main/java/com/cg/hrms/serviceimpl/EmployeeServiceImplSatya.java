package com.cg.hrms.serviceimpl;

import com.cg.hrms.entity.Employee;
import com.cg.hrms.exception.EmployeesNotFoundByLocationException;
import com.cg.hrms.repositories.EmployeeRepositorySatya;
import com.cg.hrms.service.EmployeeServiceSatya;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImplSatya implements EmployeeServiceSatya {

    private final EmployeeRepositorySatya repository;

    public EmployeeServiceImplSatya(EmployeeRepositorySatya repository) {
        this.repository = repository;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    @Override
    public List<Employee> getEmployeesByLocation(Long locationId) {
        List<Employee> employees = repository.findByDepartment_Location_Id(locationId);
        if (employees.isEmpty()) {
            throw new EmployeesNotFoundByLocationException(locationId);
        }
        return employees;
    }
}