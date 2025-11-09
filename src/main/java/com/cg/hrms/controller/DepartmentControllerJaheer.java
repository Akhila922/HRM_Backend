package com.cg.hrms.controller;

import com.cg.hrms.entity.Department;
import com.cg.hrms.service.DepartmentServiceJaheer;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/jaheer/departments")
public class DepartmentControllerJaheer {

    private final DepartmentServiceJaheer departmentService;

    public DepartmentControllerJaheer(DepartmentServiceJaheer departmentService) {
        this.departmentService = departmentService;
    }

    @Operation(summary = "Get Department by Employee ID", description = "Fetch department details for a given employee ID")
    @GetMapping("/by-employee/{employeeId}")
    public ResponseEntity<Department> getDepartmentByEmployeeId(
            @Parameter(description = "Employee ID", example = "101")
            @PathVariable("employeeId") Long employeeId) {
        Department department = departmentService.getDepartmentByEmployeeId(employeeId);
        return ResponseEntity.ok(department);
    }
}