package com.cg.hrms.dto;

public class EmployeeDTO {

    private Long employeeId;
    private String fullName;
    private String email;
    private String phoneNumber;
    private String jobTitle;
    private String managerName;

    public EmployeeDTO(Long employeeId, String fullName, String email, String phoneNumber, String jobTitle) {
        this.employeeId = employeeId;
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.jobTitle = jobTitle;
    }

    // Getters and Setters
    public Long getEmployeeId() { return employeeId; }
    public void setEmployeeId(Long employeeId) { this.employeeId = employeeId; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getJobTitle() { return jobTitle; }
    public void setJobTitle(String jobTitle) { this.jobTitle = jobTitle; }

    public String getManagerName() { return managerName; }
    public void setManagerName(String managerName) { this.managerName = managerName; }
}