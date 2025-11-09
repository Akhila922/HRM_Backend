package com.cg.hrms;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.cg.hrms.entity.Employee;
import com.cg.hrms.repositories.EmployeeRepositoryJaheer;
import com.cg.hrms.serviceimpl.EmployeeServiceImplJaheer;

class EmployeeServiceTest {

    @Mock
    private EmployeeRepositoryJaheer repository;

    @InjectMocks
    private EmployeeServiceImplJaheer service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllEmployees() {
        Employee e1 = new Employee();
        e1.setEmployeeId(1L);
        e1.setFirstName("John");
        e1.setLastName("Doe");

        Employee e2 = new Employee();
        e2.setEmployeeId(2L);
        e2.setFirstName("Jane");
        e2.setLastName("Smith");

        when(repository.findAll()).thenReturn(Arrays.asList(e1, e2));

        List<Employee> result = service.getAllEmployees();

        assertEquals(2, result.size());
        assertEquals("John", result.get(0).getFirstName());
        verify(repository, times(1)).findAll();
    }
}
