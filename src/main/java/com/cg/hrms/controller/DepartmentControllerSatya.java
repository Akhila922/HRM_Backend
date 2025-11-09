package com.cg.hrms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cg.hrms.entity.Department;
import com.cg.hrms.repositories.DepartmentRepositorySatya;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/satya/locations/{locationId}/departments")
public class DepartmentControllerSatya {

    @Autowired
    private DepartmentRepositorySatya departmentRepository;

    @GetMapping
    public List<Department> getDepartmentsByLocation(@PathVariable Long locationId) {
        return departmentRepository.findByLocation_Id(locationId);
    }
}
