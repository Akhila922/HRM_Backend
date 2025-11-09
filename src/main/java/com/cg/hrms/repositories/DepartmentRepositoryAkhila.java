package com.cg.hrms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

import com.cg.hrms.entity.Department;

public interface DepartmentRepositoryAkhila extends JpaRepository<Department, Long> {

	List<Department> findByDepartmentNameContainingIgnoreCase(String departmentname);

}