package com.cg.hrms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.hrms.entity.Job;
import com.cg.hrms.repositories.JobRepositoryVishnu;

@Service
public class JobServiceVishnu {
    private final JobRepositoryVishnu jobRepository;

    public JobServiceVishnu(JobRepositoryVishnu jobRepository) {
        this.jobRepository = jobRepository;
    }

    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    public Job getJobById(String jobId) {
        return jobRepository.findById(jobId).orElse(null);
    }
}