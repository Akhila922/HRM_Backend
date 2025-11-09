package com.cg.hrms.serviceimpl;

import com.cg.hrms.dto.CountryDtoSwathi;
import com.cg.hrms.entity.Country;
import com.cg.hrms.repositories.CountryRepositorySwathi;
import com.cg.hrms.service.CountryServiceSwathi;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountryServiceImplSwathi implements CountryServiceSwathi {

	private final CountryRepositorySwathi repo;

	public CountryServiceImplSwathi(CountryRepositorySwathi repo) {
		this.repo = repo;
	}

	@Override
	public List<CountryDtoSwathi> getAllCountriesWithCities() {
	    return repo.findAll().stream().map(country -> {
	        CountryDtoSwathi dto = new CountryDtoSwathi();

	        dto.setCountryId(country.getId());  // ✅ Always set this
	        dto.setCountryName(country.getCountryName() != null ? country.getCountryName() : country.getName());

	        dto.setCities(
	            country.getLocations() != null
	                ? country.getLocations().stream()
	                    .map(loc -> loc.getCity())
	                    .filter(city -> city != null && !city.isBlank())
	                    .distinct()
	                    .sorted(String::compareToIgnoreCase)
	                    .collect(Collectors.toList())
	                : List.of()
	        );

	        return dto;
	    }).collect(Collectors.toList());
	}


}