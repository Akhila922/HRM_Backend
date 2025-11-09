package com.cg.hrms.controller;

import com.cg.hrms.dto.LocationDtoSwathi;
import com.cg.hrms.service.LocationServiceSwathi;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/swathi/employees")
@CrossOrigin(origins = "*")
@Tag(name = "Employee API - Swathi", description = "Fetch employees by city")
public class EmployeeControllerSwathi {

    private final LocationServiceSwathi locationService;

    public EmployeeControllerSwathi(LocationServiceSwathi locationService) {
        this.locationService = locationService;
    }

    @Operation(summary = "By city → department name, employee details")
    @GetMapping("/city/{cityName}/summary")
    public LocationDtoSwathi getEmployeesByCity(@PathVariable String cityName) {
        return locationService.getCityDetails(cityName);
    }
}