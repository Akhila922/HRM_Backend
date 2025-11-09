//package com.cg.hrms.controller;
//
//import com.cg.hrms.dto.EmployeeDtoVishnu;
//import com.cg.hrms.repositories.EmployeeRepositoryAkhila; // or your Vishnu repo if exists
//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.tags.Tag;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@RestController
//@RequestMapping("/vishnu/employees")
//@Tag(name = "Employee API - Vishnu", description = "Endpoints managed by Vishnu")
//@CrossOrigin(origins = "http://localhost:9191")
//public class EmployeeControllerVishnu {
//
//    @Autowired
//    private EmployeeRepositoryAkhila employeeRepository;
//
//    @Operation(summary = "Get all employees with department and location details")
//    @GetMapping
//    public List<EmployeeDtoVishnu> getAllEmployees() {
//        return employeeRepository.findAll().stream().map(emp -> {
//            EmployeeDtoVishnu dto = new EmployeeDtoVishnu();
//            dto.setEmployeeId(emp.getEmployeeId());
//            dto.setFirstName(emp.getFirstName());
//            dto.setLastName(emp.getLastName());
//            dto.setEmail(emp.getEmail());
//            dto.setPhoneNumber(emp.getPhoneNumber());
//
//            // Map Department and Location details safely
//            if (emp.getDepartment() != null) {
//                dto.setDepartmentName(emp.getDepartment().getDepartmentName());
//
//                if (emp.getDepartment().getLocation() != null) {
//                    dto.setLocationName(emp.getDepartment().getLocation().getCity());
//                } else {
//                    dto.setLocationName("N/A");
//                }
//            } else {
//                dto.setDepartmentName("N/A");
//                dto.setLocationName("N/A");
//            }
//
//            return dto;
//        }).collect(Collectors.toList());
//    }
//}


package com.cg.hrms.controller;

import com.cg.hrms.dto.EmployeeDtoVishnu;
import com.cg.hrms.exception.ResourceNotFoundException;
import com.cg.hrms.repositories.EmployeeRepositoryAkhila;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/vishnu/employees")
@Tag(name = "Employee API - Vishnu", description = "Endpoints managed by Vishnu")
@CrossOrigin(origins = "*")
public class EmployeeControllerVishnu {

    @Autowired
    private EmployeeRepositoryAkhila employeeRepository;

    @Operation(summary = "Get all employees with department and location details")
    @GetMapping
    public List<EmployeeDtoVishnu> getAllEmployees() {
        List<EmployeeDtoVishnu> employees = employeeRepository.findAll().stream().map(emp -> {
            EmployeeDtoVishnu dto = new EmployeeDtoVishnu();
            dto.setEmployeeId(emp.getEmployeeId());
            dto.setFirstName(emp.getFirstName());
            dto.setLastName(emp.getLastName());
            dto.setEmail(emp.getEmail());
            dto.setPhoneNumber(emp.getPhoneNumber());

            if (emp.getDepartment() != null) {
                dto.setDepartmentName(emp.getDepartment().getDepartmentName());
                dto.setLocationName(emp.getDepartment().getLocation() != null
                        ? emp.getDepartment().getLocation().getCity() : "N/A");
            } else {
                dto.setDepartmentName("N/A");
                dto.setLocationName("N/A");
            }

            return dto;
        }).collect(Collectors.toList());

        if (employees.isEmpty()) {
            throw new ResourceNotFoundException("No employee records found.");
        }

        return employees;
    }
}
