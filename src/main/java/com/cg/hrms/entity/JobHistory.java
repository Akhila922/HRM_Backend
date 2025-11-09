package com.cg.hrms.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "job_history")
public class JobHistory {

//    @EmbeddedId
//    private JobHistoryId id;
    
    @EmbeddedId
    private JobHistoryId id;

    public JobHistoryId id() { return id; }
    public void id(JobHistoryId id) { this.id = id; }


    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job job;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    // ✅ Add this relation to fetch employee details
    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id", insertable = false, updatable = false)
    private Employee employee;

    @Column(name = "end_date")
    private LocalDate endDate;

    // Getters and Setters
    public JobHistoryId getId() { return id; }
    public void setId(JobHistoryId id) { this.id = id; }

    public Job getJob() { return job; }
    public void setJob(Job job) { this.job = job; }

    public Department getDepartment() { return department; }
    public void setDepartment(Department department) { this.department = department; }

    public Employee getEmployee() { return employee; } // ✅ Now available
    public void setEmployee(Employee employee) { this.employee = employee; }

    public LocalDate getEndDate() { return endDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }
}

