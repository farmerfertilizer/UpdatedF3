package com.farmer.ManufacturerService.repository;

import com.farmer.ManufacturerService.model.Crops;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CropsRepository extends JpaRepository<Crops,Integer> {
}
