package com.cg.hrms.repositories;

import com.cg.hrms.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepositoryAkhila extends JpaRepository<Employee, Long> {
	List<Employee> findByDepartmentDepartmentId(Long departmentId);
}
