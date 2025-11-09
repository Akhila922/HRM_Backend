package com.cg.hrms.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.hrms.entity.Employee;

public interface EmployeeRepositoryVishnu extends JpaRepository<Employee, Long> {
    List<Employee> findByJob_JobId(String jobId);
}