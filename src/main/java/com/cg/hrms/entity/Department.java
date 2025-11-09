package com.cg.hrms.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "departments")
public class Department {

	@Id
	@Column(name = "department_id")
	private Long departmentId;

	@Column(name = "department_name")
	private String departmentName;

	@Column(name = "manager_id")
	private Long managerId;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "manager_id", referencedColumnName = "employee_id", insertable = false, updatable = false)
	private Employee manager;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "location_id")
	private Location location;

	@OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Employee> employees;

	// Getters and Setters

	public Long getDepartmentId() {
	    return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
	    this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Long getManagerId() {
		return managerId;
	}

	public void setManagerId(Long managerId) {
		this.managerId = managerId;
	}

	public Employee getManager() {
		return manager;
	}

	public void setManager(Employee manager) {
		this.manager = manager;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

}