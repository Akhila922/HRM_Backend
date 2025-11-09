package com.cg.hrms.exception;

public class EmployeesNotFoundByLocationException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmployeesNotFoundByLocationException(Long locationId) {
        super("No employees found for location ID: " + locationId);
    }
}
