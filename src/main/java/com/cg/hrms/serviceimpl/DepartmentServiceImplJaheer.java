package com.cg.hrms.serviceimpl;

//import org.springframework.stereotype.Service;
//import com.cg.hrms.entity.Department;
//import com.cg.hrms.entity.Employee;
//import com.cg.hrms.repositories.EmployeeRepositoryJaheer;
//import com.cg.hrms.service.DepartmentServiceJaheer;
//
//@Service
//public class DepartmentServiceImplJaheer implements DepartmentServiceJaheer {
//
//    private final EmployeeRepositoryJaheer employeeRepository;
//
//    public DepartmentServiceImplJaheer(EmployeeRepositoryJaheer employeeRepository) {
//        this.employeeRepository = employeeRepository;
//    }
//
//    @Override
//    public Department getDepartmentByEmployeeId(Long employeeId) {
//        Employee employee = employeeRepository.findById(employeeId)
//                .orElseThrow(() -> new RuntimeException("Employee not found with ID: " + employeeId));
//        return employee.getDepartment();
//    }
//}




import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.cg.hrms.entity.Department;
import com.cg.hrms.entity.Employee;
import com.cg.hrms.repositories.EmployeeRepositoryJaheer;
import com.cg.hrms.service.DepartmentServiceJaheer;

@Service
public class DepartmentServiceImplJaheer implements DepartmentServiceJaheer {

    private final EmployeeRepositoryJaheer employeeRepository;

    public DepartmentServiceImplJaheer(EmployeeRepositoryJaheer employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    @Transactional
    public Department getDepartmentByEmployeeId(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found with ID: " + employeeId));

        Department department = employee.getDepartment();
        if (department == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Department not found for employee ID: " + employeeId);
        }
        return department;
    }
}