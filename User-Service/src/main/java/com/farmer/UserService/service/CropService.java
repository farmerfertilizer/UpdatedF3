package com.farmer.UserService.service;

import com.farmer.UserService.dto.Crops;
import com.farmer.UserService.repository.CropRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CropService {

    @Autowired
    private CropRepo cropRepo;
    public Crops getCropById(int cropId) throws  Exception{
        return cropRepo.findById(cropId).orElseThrow();
    }
}
