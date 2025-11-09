package com.cg.hrms.controller;

import com.cg.hrms.dto.CountryDtoSwathi;
import com.cg.hrms.service.CountryServiceSwathi;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/swathi/countries")
@Tag(name = "Country API - Swathi", description = "Endpoints managed by Swathi")
@CrossOrigin(origins = "*")
public class CountryControllerSwathi {

    private final CountryServiceSwathi countryService;

    public CountryControllerSwathi(CountryServiceSwathi countryService) {
        this.countryService = countryService;
    }

    @Operation(summary = "Countries + Cities")
    @GetMapping("/with-cities")
    public List<CountryDtoSwathi> getCountriesWithCities() {
        return countryService.getAllCountriesWithCities();
    }
}