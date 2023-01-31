package com.farmer.UserService.repository;

import com.farmer.UserService.dto.Fertilizer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FertilizerRepo extends JpaRepository<Fertilizer,Integer> {

}
