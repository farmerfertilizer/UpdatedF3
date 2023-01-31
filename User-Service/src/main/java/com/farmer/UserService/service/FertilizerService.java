package com.farmer.UserService.service;

import com.farmer.UserService.dto.Fertilizer;
import com.farmer.UserService.repository.FertilizerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FertilizerService {

    @Autowired
    private FertilizerRepo fertilizerRepo;

    public Fertilizer getFertilizerById(int fertilizerId)  throws Exception{
      return   fertilizerRepo.findById(fertilizerId).orElseThrow();
    }
}
