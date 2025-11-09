package com.cg.hrms.serviceimpl;

import com.cg.hrms.dto.RegionDto;
import com.cg.hrms.repositories.RegionRepositoryVighnesh;
import com.cg.hrms.service.RegionServiceVighnesh;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RegionServiceImplVighnesh implements RegionServiceVighnesh {

    private final RegionRepositoryVighnesh repo;

    public RegionServiceImplVighnesh(RegionRepositoryVighnesh repo) {
        this.repo = repo;
    }

    @Override
    public List<RegionDto> getAllRegions() {
        return repo.findAll()
                   .stream()
                   .map(r -> new RegionDto(r.getId(), r.getName()))
                   .collect(Collectors.toList());
    }

    @Override
    public RegionDto getRegionById(Long id) {
        return repo.findById(id)
                   .map(r -> new RegionDto(r.getId(), r.getName()))
                   .orElse(null);
    }
}