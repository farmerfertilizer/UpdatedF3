package com.farmer.ManufacturerService.service;

import com.farmer.ManufacturerService.exception.FertilizerNotFoundException;
import com.farmer.ManufacturerService.exception.ManufacturerNotFoundException;
import com.farmer.ManufacturerService.model.Crops;
import com.farmer.ManufacturerService.model.Fertilizer;
import com.farmer.ManufacturerService.repository.CropsRepository;
import com.farmer.ManufacturerService.repository.FertilizerRepository;
import com.farmer.ManufacturerService.repository.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FertilizerService {

    @Autowired
    FertilizerRepository fertilizerRepository;

    @Autowired
    ManufacturerRepository manurepo;

    public Fertilizer addFertilizer(int manufacterId,Fertilizer fertilizer) throws ManufacturerNotFoundException /*throws FertilizerNotFoundException*/ {

        Fertilizer prd= manurepo.findById(manufacterId).map(manufacturer -> {
            fertilizer.setManufacturer(manufacturer);
            return fertilizerRepository.save(fertilizer);
        }).orElseThrow(() ->
                new ManufacturerNotFoundException
                        ("Not found Manufacturer with id = " + manufacterId));
        return prd;
    }
    public Fertilizer updateFertilizer(Fertilizer fertilizer) {
        Fertilizer ferti=new Fertilizer();
        Optional<Fertilizer> updateFertilizer=fertilizerRepository.findById(ferti.getFertilizerId());
        if(updateFertilizer.isPresent()) {
            fertilizer.setFertilizerId(updateFertilizer.get().getFertilizerId());
            fertilizer.setFertilizerName(updateFertilizer.get().getFertilizerName());
            fertilizer.setCost(updateFertilizer.get().getCost());
            fertilizer.setQuantity(updateFertilizer.get().getQuantity());
        }else {
            return new Fertilizer();
        }

        return fertilizerRepository.save(fertilizer);
    }
    public List<Fertilizer> getAllFertilizers() {
        return fertilizerRepository.findAll();
    }

    public Optional<Fertilizer> getFertilizerById(Integer fertilizerId) {
        return fertilizerRepository.findById(fertilizerId);
    }

    public String deleteFertilizer(Integer fertilizerId) {
        fertilizerRepository.deleteById(fertilizerId);
        return "Success";
    }


}
