package com.cg.hrms.controller;

import com.cg.hrms.dto.EmployeeSummaryDto;
import com.cg.hrms.entity.Employee;
import com.cg.hrms.service.EmployeeServiceVighnesh;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/vighnesh/employees")
@CrossOrigin(origins = "*")
@Tag(name = "Employee API - Vighnesh", description = "Endpoints managed by Vighnesh")
public class EmployeeControllerVighnesh {

   private final EmployeeServiceVighnesh service;

   public EmployeeControllerVighnesh(EmployeeServiceVighnesh service) {
       this.service = service;
   }

   @GetMapping
   @Operation(summary = "Get all employees")
   public List<Employee> getAllEmployees() {
       return service.getAllEmployees();
   }

   @GetMapping("/{id}")
   @Operation(summary = "Get employee by ID")
   public Employee getEmployeeById(@PathVariable Long id) {
       return service.getEmployeeById(id);
   }

   @GetMapping("/country/{countryName}/summary")
   @Operation(summary = "Get employee summaries by country")
   public List<EmployeeSummaryDto> getEmployeeSummariesByCountry(@PathVariable String countryName) {
       return service.getEmployeeSummariesByCountry(countryName);
   }
}


// package com.cg.hrms.controller;

// import com.cg.hrms.dto.EmployeeSummaryDto;
// import com.cg.hrms.entity.Employee;
// import com.cg.hrms.exception.ResourceNotFoundException;
// import com.cg.hrms.service.EmployeeServiceVighnesh;
// import io.swagger.v3.oas.annotations.Operation;
// import io.swagger.v3.oas.annotations.tags.Tag;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @RestController
// @RequestMapping("/vighnesh/employees")
// @CrossOrigin(origins = "*")
// @Tag(name = "Employee API - Vighnesh", description = "Endpoints managed by Vighnesh")
// public class EmployeeControllerVighnesh {

//     private final EmployeeServiceVighnesh service;

//     public EmployeeControllerVighnesh(EmployeeServiceVighnesh service) {
//         this.service = service;
//     }

//     @GetMapping
//     @Operation(summary = "Get all employees")
//     public List<Employee> getAllEmployees() {
//         List<Employee> employees = service.getAllEmployees();
//         if (employees.isEmpty()) {
//             throw new ResourceNotFoundException("No employees found.");
//         }
//         return employees;
//     }

//     @GetMapping("/{id}")
//     @Operation(summary = "Get employee by ID")
//     public Employee getEmployeeById(@PathVariable Long id) {
//         Employee emp = service.getEmployeeById(id);
//         if (emp == null) {
//             throw new ResourceNotFoundException("Employee not found with ID: " + id);
//         }
//         return emp;
//     }

//     @GetMapping("/country/{countryName}/summary")
//     @Operation(summary = "Get employee summaries by country")
//     public List<EmployeeSummaryDto> getEmployeeSummariesByCountry(@PathVariable String countryName) {
//         List<EmployeeSummaryDto> summaries = service.getEmployeeSummariesByCountry(countryName);
//         if (summaries.isEmpty()) {
//             throw new ResourceNotFoundException("No employees found for country: " + countryName);
//         }
//         return summaries;
//     }
// }

