package com.cg.hrms.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.hrms.entity.Employee;
import com.cg.hrms.repositories.EmployeeRepositoryJaheer;
import com.cg.hrms.service.EmployeeServiceJaheer;


@Service
public class EmployeeServiceImplJaheer implements EmployeeServiceJaheer {

    private final EmployeeRepositoryJaheer repository;

    public EmployeeServiceImplJaheer(EmployeeRepositoryJaheer repository) {
        this.repository = repository;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }
}

