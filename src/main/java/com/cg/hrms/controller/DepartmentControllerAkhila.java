package com.cg.hrms.controller;

import com.cg.hrms.dto.DepartmentDtoAkhila;
import com.cg.hrms.entity.Employee;
import com.cg.hrms.service.DepartmentServiceAkhila;
import com.cg.hrms.repositories.EmployeeRepositoryAkhila;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/akhila/departments")
@Tag(name = "Department API - Akhila", description = "Endpoints managed by Akhila")
@CrossOrigin(origins = "*")
public class DepartmentControllerAkhila {

    private final DepartmentServiceAkhila service;
    private final EmployeeRepositoryAkhila employeeRepository;

    public DepartmentControllerAkhila(DepartmentServiceAkhila service, EmployeeRepositoryAkhila employeeRepository) {
        this.service = service;
        this.employeeRepository = employeeRepository;
    }

    // ✅ 1. Get all departments (DTO)
    @Operation(summary = "Get all departments with Manager and Location info")
    @GetMapping
    public List<DepartmentDtoAkhila> getAllDepartments() {
        return service.getAllDepartments();
    }

    // ✅ 2. Get all employees under a department
    @Operation(summary = "Get all employees under a department")
    @GetMapping("/{deptId}/employees")
    public List<Employee> getEmployeesByDepartmentId(@PathVariable("deptId") Long deptId) {
        return employeeRepository.findByDepartmentDepartmentId(deptId);
    }
}
