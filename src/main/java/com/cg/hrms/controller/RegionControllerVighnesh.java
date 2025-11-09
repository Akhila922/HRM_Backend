//package com.cg.hrms.controller;
//
//import com.cg.hrms.dto.RegionDto;
//import com.cg.hrms.dto.RegionWithCountriesDto;
//import com.cg.hrms.service.RegionServiceVighnesh;
//import com.cg.hrms.service.CountryServiceVighnesh;
//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.tags.Tag;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@CrossOrigin(origins = "*")
//@RestController
//@RequestMapping("/vighnesh/regions")
//@Tag(name = "Region API - Vighnesh", description = "Endpoints managed by Vighnesh")
//public class RegionControllerVighnesh {
//
//  private final RegionServiceVighnesh regionService;
//  private final CountryServiceVighnesh countryService;
//
//  public RegionControllerVighnesh(RegionServiceVighnesh regionService,
//                                  CountryServiceVighnesh countryService) {
//    this.regionService = regionService;
//    this.countryService = countryService;
//  }
//
//  @GetMapping
//  @Operation(summary = "Get all regions")
//  public List<RegionDto> getAllRegions() {
//    return regionService.getAllRegions();
//  }
//
//  @GetMapping("/{id}")
//  @Operation(summary = "Get region by ID")
//  public RegionDto getRegionById(@PathVariable Long id) {
//    return regionService.getRegionById(id);
//  }
//
//  @GetMapping("/with-countries")
//  @Operation(summary = "Regions + Countries list (landing data)")
//  public List<RegionWithCountriesDto> withCountries() {
//    return countryService.getRegionsWithCountries();
//  }
//}


package com.cg.hrms.controller;

import com.cg.hrms.dto.RegionDto;
import com.cg.hrms.dto.RegionWithCountriesDto;
import com.cg.hrms.exception.InvalidRequestException;
import com.cg.hrms.exception.ResourceNotFoundException;
import com.cg.hrms.service.RegionServiceVighnesh;
import com.cg.hrms.service.CountryServiceVighnesh;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/vighnesh/regions")
@Tag(name = "Region API - Vighnesh", description = "Endpoints managed by Vighnesh")
public class RegionControllerVighnesh {

  private final RegionServiceVighnesh regionService;
  private final CountryServiceVighnesh countryService;

  public RegionControllerVighnesh(RegionServiceVighnesh regionService,
                                  CountryServiceVighnesh countryService) {
    this.regionService = regionService;
    this.countryService = countryService;
  }

  @GetMapping
  @Operation(summary = "Get all regions")
  public List<RegionDto> getAllRegions() {
    List<RegionDto> regions = regionService.getAllRegions();
    if (regions.isEmpty()) {
      throw new ResourceNotFoundException("No regions found.");
    }
    return regions;
  }

  @GetMapping("/{id}")
  @Operation(summary = "Get region by ID")
  public RegionDto getRegionById(@PathVariable Long id) {
    if (id <= 0) {
      throw new InvalidRequestException("Invalid region ID: must be positive.");
    }

    RegionDto region = regionService.getRegionById(id);
    if (region == null) {
      throw new ResourceNotFoundException("Region not found with ID: " + id);
    }

    return region;
  }

  @GetMapping("/with-countries")
  @Operation(summary = "Regions + Countries list (landing data)")
  public List<RegionWithCountriesDto> withCountries() {
    List<RegionWithCountriesDto> regions = countryService.getRegionsWithCountries();
    if (regions.isEmpty()) {
      throw new ResourceNotFoundException("No region-country mapping found.");
    }
    return regions;
  }
}
