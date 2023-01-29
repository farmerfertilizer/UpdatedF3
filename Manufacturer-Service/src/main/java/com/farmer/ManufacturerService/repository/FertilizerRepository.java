package com.farmer.ManufacturerService.repository;

import com.farmer.ManufacturerService.model.Fertilizer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FertilizerRepository extends JpaRepository<Fertilizer,Integer> {
}
