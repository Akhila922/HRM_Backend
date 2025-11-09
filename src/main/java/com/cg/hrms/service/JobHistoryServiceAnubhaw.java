package com.cg.hrms.service;

import com.cg.hrms.entity.JobHistory;
import java.util.List;

public interface JobHistoryServiceAnubhaw {
    List<JobHistory> getJobHistoryByEmployeeId(Long employeeId);
}
