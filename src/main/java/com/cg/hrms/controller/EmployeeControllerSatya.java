package com.cg.hrms.controller;

import com.cg.hrms.entity.Employee;
import com.cg.hrms.service.EmployeeServiceSatya;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
//@RequestMapping("/satya/employees")
//public class EmployeeControllerSatya {
//
//    private final EmployeeServiceSatya employeeService;
//
//    public EmployeeControllerSatya(EmployeeServiceSatya employeeService) {
//        this.employeeService = employeeService;
//    }
//
////    @GetMapping
////    public List<Employee> getAllEmployees() {
////        return employeeService.getAllEmployees();
////    }
//
//    @GetMapping("/location/{locationId}")
//    public List<Employee> getEmployeesByLocation(@PathVariable Long locationId) {
//        return employeeService.getEmployeesByLocation(locationId);
//    }
//}

@RestController
@RequestMapping("/satya/employees")
//@CrossOrigin(origins = "http://localhost:9191")
@CrossOrigin(origins = "*")
public class EmployeeControllerSatya {

    private final EmployeeServiceSatya employeeService;

    public EmployeeControllerSatya(EmployeeServiceSatya employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/location/{locationId}")
    public List<Employee> getEmployeesByLocation(@PathVariable Long locationId) {
        return employeeService.getEmployeesByLocation(locationId);
    }
}