package com.cg.hrms.controller;
 
import com.cg.hrms.dto.LocationDTO;

import com.cg.hrms.entity.Location;

import com.cg.hrms.repositories.LocationRepositorySatya;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
 
import java.util.List;

import java.util.stream.Collectors;
 
//@RestController
//
//@RequestMapping("/satya/locations")
//
//public class LocationControllerSatya {
// 
//    @Autowired
//
//    private LocationRepositorySatya locationRepository;
// 
//    @GetMapping
//
//    public List<LocationDTO> getAllLocations() {
//
//        return locationRepository.findAll().stream().map(location -> {
//
//            LocationDTO dto = new LocationDTO();
//
//            dto.setId(location.getId());
//
//            dto.setStreetAddress(location.getStreetAddress());
//
//            dto.setPostalCode(location.getPostalCode());
//
//            dto.setCity(location.getCity());
//
//            dto.setStateProvince(location.getStateProvince());
//
//            dto.setCountryName(location.getCountry() != null ? location.getCountry().getCountryName() : null);
//
//            return dto;
//
//        }).collect(Collectors.toList());
//
//    }
//
//}


//import com.cg.hrms.dto.LocationDTO;
//import com.cg.hrms.entity.Location;
//import com.cg.hrms.repositories.LocationRepositorySatya;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.stream.Collectors;

//@CrossOrigin(origins = "http://localhost:9191")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/satya/locations")
public class LocationControllerSatya {

    @Autowired
    private LocationRepositorySatya locationRepository;

    @GetMapping
    public List<LocationDTO> getAllLocations() {
        return locationRepository.findAll().stream().map(location -> {
            LocationDTO dto = new LocationDTO();
            dto.setId(location.getId());
            dto.setStreetAddress(location.getStreetAddress());
            dto.setPostalCode(location.getPostalCode());
            dto.setCity(location.getCity());
            dto.setStateProvince(location.getStateProvince());
            dto.setCountryName(location.getCountry() != null ? location.getCountry().getCountryName() : null);
            return dto;
        }).collect(Collectors.toList());
    }
}



 