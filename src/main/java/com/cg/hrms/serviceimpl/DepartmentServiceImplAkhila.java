package com.cg.hrms.serviceimpl;

import com.cg.hrms.dto.DepartmentDtoAkhila;
import com.cg.hrms.repositories.DepartmentRepositoryAkhila;
import com.cg.hrms.service.DepartmentServiceAkhila;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImplAkhila implements DepartmentServiceAkhila {

    private final DepartmentRepositoryAkhila repo;

    public DepartmentServiceImplAkhila(DepartmentRepositoryAkhila repo) {
        this.repo = repo;
    }

    @Override
    public List<DepartmentDtoAkhila> getAllDepartments() {
        return repo.findAll().stream().map(dept -> {
            DepartmentDtoAkhila dto = new DepartmentDtoAkhila();
            dto.setDepartmentId(dept.getDepartmentId());
            dto.setDepartmentName(dept.getDepartmentName());
            dto.setManagerId(dept.getManagerId());

            // ✅ Safely handle null locations
            if (dept.getLocation() != null) {
                dto.setLocationId(dept.getLocation().getLocationId());
            } else {
                dto.setLocationId(null);
            }

            return dto;
        }).collect(Collectors.toList());
    }
}
