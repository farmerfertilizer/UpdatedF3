package com.farmer.ManufacturerService.service;

import com.farmer.ManufacturerService.exception.ManufacturerNotFoundException;
import com.farmer.ManufacturerService.model.Crops;
import com.farmer.ManufacturerService.model.Manufacturer;
import com.farmer.ManufacturerService.repository.CropsRepository;
import com.farmer.ManufacturerService.repository.ManufacturerRepository;
import org.hibernate.boot.MappingNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CropsService {

    @Autowired
    CropsRepository cropsRepository;
    @Autowired
    ManufacturerRepository manurepo;

    public Crops addCrops(int manufacturerId , Crops crops) throws ManufacturerNotFoundException   {

        Crops prd= manurepo.findById(manufacturerId).map(manufacturer -> {
            crops.setManufacturer(manufacturer);
            return cropsRepository.save(crops);
        }).orElseThrow(() ->
                new ManufacturerNotFoundException
                        ("Not found Manufacturer with id = " + manufacturerId));
                return prd;
    }

    public Crops updateCrop(Crops crops) {
        Crops crop=new Crops();
        Optional<Crops> updateCrop=cropsRepository.findById(crop.getCropId());
        if(updateCrop.isPresent()){
            crop.setCropId(updateCrop.get().getCropId());
            crop.setCropName(updateCrop.get().getCropName());
            crop.setCost(updateCrop.get().getCost());
            crop.setQuantity(updateCrop.get().getQuantity());
        }else{
            return new Crops();
        }
        return  cropsRepository.save(crops);
    }

    public List<Crops> getAllCrops() {
        return cropsRepository.findAll();
    }

    public Optional<Crops> getCropById(Integer cropid) {
        return cropsRepository.findById(cropid);
    }

    public String deleteCrop(Integer cropId) {
         cropsRepository.deleteById(cropId);
         return "Success";
    }


}
