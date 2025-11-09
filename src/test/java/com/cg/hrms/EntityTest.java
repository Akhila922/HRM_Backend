package com.cg.hrms;

import org.junit.jupiter.api.Test;

import com.cg.hrms.entity.Employee;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EntityTest {

    @Test
    void testEmployeeGettersAndSetters() {
        Employee e = new Employee();
        e.setEmployeeId(1L);
        e.setFirstName("John");
        e.setLastName("Doe");
        e.setEmail("john@example.com");

        assertEquals(1L, e.getEmployeeId());
        assertEquals("John", e.getFirstName());
        assertEquals("Doe", e.getLastName());
        assertEquals("john@example.com", e.getEmail());
    }
}
