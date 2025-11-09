package com.cg.hrms.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.hrms.entity.Department;

public interface DepartmentRepositorySatya extends JpaRepository<Department, Long> {
    List<Department> findByLocation_Id(Long locationId);
}



