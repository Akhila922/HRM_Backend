package com.cg.hrms.controller;

import org.springframework.web.bind.annotation.*;

import com.cg.hrms.entity.JobHistory;
import com.cg.hrms.service.JobHistoryServiceAnubhaw;

import java.util.List;

@RestController
@RequestMapping("/anubhaw/job-history")
@CrossOrigin("*")
public class JobHistoryControllerAnubhaw {

    private final JobHistoryServiceAnubhaw jobHistoryService;

    public JobHistoryControllerAnubhaw(JobHistoryServiceAnubhaw jobHistoryService) {
        this.jobHistoryService = jobHistoryService;
    }

    @GetMapping("/employee/{id}")
    public List<JobHistory> getJobHistoryByEmployeeId(@PathVariable Long id) {
        return jobHistoryService.getJobHistoryByEmployeeId(id);
    }
}
