package com.cg.hrms.dto;

public class DepartmentDTO {
    private Long id;
    private String departmentName;
    private String locationCity;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDepartmentName() { return departmentName; }
    public void setDepartmentName(String departmentName) { this.departmentName = departmentName; }

    public String getLocationCity() { return locationCity; }
    public void setLocationCity(String locationCity) { this.locationCity = locationCity; }
}