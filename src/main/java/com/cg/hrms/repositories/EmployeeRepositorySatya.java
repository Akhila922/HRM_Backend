package com.cg.hrms.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.hrms.entity.Employee;

public interface EmployeeRepositorySatya extends JpaRepository<Employee, Long> {
    List<Employee> findByDepartment_Location_Id(Long locationId);
}