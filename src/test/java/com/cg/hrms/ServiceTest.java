package com.cg.hrms;

import com.cg.hrms.entity.Employee;
import com.cg.hrms.repositories.EmployeeRepositoryJaheer;
import com.cg.hrms.serviceimpl.EmployeeServiceImplJaheer;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ServiceTest {

    @Mock
    private EmployeeRepositoryJaheer repository;

    @InjectMocks
    private EmployeeServiceImplJaheer service;

    @Test
    void testGetAllEmployees() {
        Employee e1 = new Employee();
        e1.setEmployeeId(1L);
        e1.setFirstName("John");

        Employee e2 = new Employee();
        e2.setEmployeeId(2L);
        e2.setFirstName("Jane");

        when(repository.findAll()).thenReturn(Arrays.asList(e1, e2));

        List<Employee> result = service.getAllEmployees();
        assertEquals(2, result.size());
        assertEquals("John", result.get(0).getFirstName());
    }
}
