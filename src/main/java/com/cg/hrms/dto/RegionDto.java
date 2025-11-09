package com.cg.hrms.dto;

public class RegionDto {
    private Long id;
    private String name;

    public RegionDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
}
