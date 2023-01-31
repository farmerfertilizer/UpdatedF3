package com.farmer.ManufacturerService.repository;

import com.farmer.ManufacturerService.model.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ManufacturerRepository extends JpaRepository<Manufacturer,Integer> {

    Optional<Manufacturer> findByName(String name);

    boolean existsByName(String name);
}
