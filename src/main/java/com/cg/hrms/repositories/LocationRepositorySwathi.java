package com.cg.hrms.repositories;

import com.cg.hrms.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepositorySwathi extends JpaRepository<Location, Long> {
    Location findByCityIgnoreCase(String city);
}