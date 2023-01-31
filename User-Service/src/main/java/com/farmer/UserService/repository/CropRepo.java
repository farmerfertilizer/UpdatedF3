package com.farmer.UserService.repository;

import com.farmer.UserService.dto.Crops;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CropRepo extends JpaRepository<Crops,Integer> {

}
