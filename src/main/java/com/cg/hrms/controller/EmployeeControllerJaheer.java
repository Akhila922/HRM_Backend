package com.cg.hrms.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.hrms.entity.Employee;
import com.cg.hrms.service.EmployeeServiceJaheer;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/jaheer/employees")
public class EmployeeControllerJaheer {

    private final EmployeeServiceJaheer employeeService;

    public EmployeeControllerJaheer(EmployeeServiceJaheer employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
}