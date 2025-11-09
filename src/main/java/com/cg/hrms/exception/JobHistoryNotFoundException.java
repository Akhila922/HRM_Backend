package com.cg.hrms.exception;

public class JobHistoryNotFoundException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JobHistoryNotFoundException(Long employeeId) {
        super("No job history found for employee ID: " + employeeId);
    }
}