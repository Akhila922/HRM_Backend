package com.cg.hrms.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.*;

import com.cg.hrms.entity.Job;
import com.cg.hrms.dto.EmployeeDtoVishnu;
import com.cg.hrms.entity.Employee;
import com.cg.hrms.service.JobServiceVishnu;
import com.cg.hrms.service.EmployeeServiceVishnu;

@RestController
@RequestMapping("/api/jobs")
@CrossOrigin(origins = "*")
public class JobControllerVishnu {

   private final JobServiceVishnu jobService;
   private final EmployeeServiceVishnu employeeService;

   public JobControllerVishnu(JobServiceVishnu jobService, EmployeeServiceVishnu employeeService) {
       this.jobService = jobService;
       this.employeeService = employeeService;
   }

   @GetMapping
   public List<Job> getAllJobs() {
       return jobService.getAllJobs();
   }

//    @GetMapping("/{jobId}/employees")
//    public List<Employee> getEmployeesByJob(@PathVariable String jobId) {
//        return employeeService.getEmployeesByJobId(jobId);
//    }
   
   
   // ✅ Fetch all employees by Job ID (with department & location)
   @GetMapping("/{jobId}/employees")
   public List<EmployeeDtoVishnu> getEmployeesByJob(@PathVariable String jobId) {
       return employeeService.getEmployeesByJobId(jobId).stream().map(emp -> {
           EmployeeDtoVishnu dto = new EmployeeDtoVishnu();
           dto.setEmployeeId(emp.getEmployeeId());
           dto.setFirstName(emp.getFirstName());
           dto.setLastName(emp.getLastName());
           dto.setEmail(emp.getEmail());
           dto.setPhoneNumber(emp.getPhoneNumber());
           dto.setSalary(emp.getSalary());

           // ✅ Include Department & Location names safely
           if (emp.getDepartment() != null) {
               dto.setDepartmentName(emp.getDepartment().getDepartmentName());
               if (emp.getDepartment().getLocation() != null) {
                   dto.setLocationName(emp.getDepartment().getLocation().getCity());
               } else {
                   dto.setLocationName("N/A");
               }
           } else {
               dto.setDepartmentName("N/A");
               dto.setLocationName("N/A");
           }

           return dto;
       }).collect(Collectors.toList());
   }
}


// package com.cg.hrms.controller;

// import java.util.List;
// import java.util.stream.Collectors;

// import org.springframework.web.bind.annotation.*;

// import com.cg.hrms.entity.Job;
// import com.cg.hrms.dto.EmployeeDtoVishnu;
// import com.cg.hrms.entity.Employee;
// import com.cg.hrms.exception.InvalidRequestException;
// import com.cg.hrms.exception.ResourceNotFoundException;
// import com.cg.hrms.service.JobServiceVishnu;
// import com.cg.hrms.service.EmployeeServiceVishnu;

// @RestController
// @RequestMapping("/api/jobs")
// @CrossOrigin(origins = "*")
// public class JobControllerVishnu {

//     private final JobServiceVishnu jobService;
//     private final EmployeeServiceVishnu employeeService;

//     public JobControllerVishnu(JobServiceVishnu jobService, EmployeeServiceVishnu employeeService) {
//         this.jobService = jobService;
//         this.employeeService = employeeService;
//     }

//     @GetMapping
//     public List<Job> getAllJobs() {
//         List<Job> jobs = jobService.getAllJobs();
//         if (jobs.isEmpty()) {
//             throw new ResourceNotFoundException("No job records found.");
//         }
//         return jobs;
//     }

//     @GetMapping("/{jobId}/employees")
//     public List<EmployeeDtoVishnu> getEmployeesByJob(@PathVariable String jobId) {
//         if (jobId == null || jobId.trim().isEmpty()) {
//             throw new InvalidRequestException("Job ID cannot be null or empty.");
//         }

//         List<Employee> employees = employeeService.getEmployeesByJobId(jobId);
//         if (employees.isEmpty()) {
//             throw new ResourceNotFoundException("No employees found for job ID: " + jobId);
//         }

//         return employees.stream().map(emp -> {
//             EmployeeDtoVishnu dto = new EmployeeDtoVishnu();
//             dto.setEmployeeId(emp.getEmployeeId());
//             dto.setFirstName(emp.getFirstName());
//             dto.setLastName(emp.getLastName());
//             dto.setEmail(emp.getEmail());
//             dto.setPhoneNumber(emp.getPhoneNumber());
//             dto.setSalary(emp.getSalary());

//             if (emp.getDepartment() != null) {
//                 dto.setDepartmentName(emp.getDepartment().getDepartmentName());
//                 dto.setLocationName(emp.getDepartment().getLocation() != null
//                         ? emp.getDepartment().getLocation().getCity() : "N/A");
//             } else {
//                 dto.setDepartmentName("N/A");
//                 dto.setLocationName("N/A");
//             }

//             return dto;
//         }).collect(Collectors.toList());
//     }
// }


