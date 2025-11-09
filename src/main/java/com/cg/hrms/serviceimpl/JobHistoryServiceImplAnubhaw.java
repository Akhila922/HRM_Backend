package com.cg.hrms.serviceimpl;

import com.cg.hrms.entity.JobHistory;
import com.cg.hrms.exception.JobHistoryNotFoundException;
import com.cg.hrms.repositories.JobHistoryRepositoryAnubhaw;
import com.cg.hrms.service.JobHistoryServiceAnubhaw;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobHistoryServiceImplAnubhaw implements JobHistoryServiceAnubhaw {

    private final JobHistoryRepositoryAnubhaw jobHistoryRepository;

    public JobHistoryServiceImplAnubhaw(JobHistoryRepositoryAnubhaw jobHistoryRepository) {
        this.jobHistoryRepository = jobHistoryRepository;
    }

//    @Override
//    public List<JobHistory> getJobHistoryByEmployeeId(Long employeeId) {
//        return jobHistoryRepository.findByEmployee_EmployeeId(employeeId);
//    }
    @Override
    public List<JobHistory> getJobHistoryByEmployeeId(Long employeeId) {
        List<JobHistory> jobHistoryList = jobHistoryRepository.findByEmployee_EmployeeId(employeeId);
        if (jobHistoryList.isEmpty()) {
            throw new JobHistoryNotFoundException(employeeId);
        }
        return jobHistoryList;
    }
}