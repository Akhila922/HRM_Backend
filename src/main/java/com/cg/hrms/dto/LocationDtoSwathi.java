package com.cg.hrms.dto;

import java.util.List;

public class LocationDtoSwathi {
    private String city;
    private List<DepartmentDtoSwathi> departments;

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public List<DepartmentDtoSwathi> getDepartments() { return departments; }
    public void setDepartments(List<DepartmentDtoSwathi> departments) { this.departments = departments; }
}