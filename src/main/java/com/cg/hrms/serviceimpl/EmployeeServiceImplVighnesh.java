package com.cg.hrms.serviceimpl;

import com.cg.hrms.dto.EmployeeSummaryDto;
import com.cg.hrms.entity.Employee;
import com.cg.hrms.repositories.EmployeeRepositoryVighnesh;
import com.cg.hrms.service.EmployeeServiceVighnesh;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImplVighnesh implements EmployeeServiceVighnesh {

    private final EmployeeRepositoryVighnesh employeeRepo;

    public EmployeeServiceImplVighnesh(EmployeeRepositoryVighnesh employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    // ✅ Get all employees (direct entity return)
    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepo.findAll();
    }

    // ✅ Get employee by ID (direct entity return)
    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepo.findById(id).orElse(null);
    }

    // ✅ Employee summaries by country (like your original working one)
    @Override
    public List<EmployeeSummaryDto> getEmployeeSummariesByCountry(String countryName) {
        return employeeRepo.findByDepartment_Location_Country_CountryNameIgnoreCase(countryName)
                .stream()
                .map(e -> new EmployeeSummaryDto(
                        e.getDepartment().getLocation().getCountry().getCountryName(),
                        e.getDepartment().getLocation().getCity(),
                        e.getDepartment().getLocation().getStateProvince(),
                        e.getDepartment().getDepartmentName(),
                        e.getEmployeeId(),
                        (e.getFirstName() == null ? "" : e.getFirstName() + " ") +
                                (e.getLastName() == null ? "" : e.getLastName()),
                        e.getEmail(),
                        e.getPhoneNumber()
                ))
                .toList();
    }
}
