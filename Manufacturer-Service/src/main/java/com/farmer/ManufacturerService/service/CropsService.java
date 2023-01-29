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

    public Crops addCrops(int manufacturerid , Crops crops) throws ManufacturerNotFoundException   {

        Crops prd= manurepo.findById(manufacturerid).map(manufacturer -> {
            crops.setManufacturer(manufacturer);
            return cropsRepository.save(crops);
        }).orElseThrow(() ->
                new ManufacturerNotFoundException
                        ("Not found Manufacturer with id = " + manufacturerid));
                return prd;
    }

    public Crops updateCrop(Crops crops) {
        Crops crop=new Crops();
        Optional<Crops> updateCrop=cropsRepository.findById(crop.getCrop_id());
        if(updateCrop.isPresent()){
            crop.setCrop_id(updateCrop.get().getCrop_id());
            crop.setCrop_name(updateCrop.get().getCrop_name());
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

    public String deleteCrop(Integer cropid) {
         cropsRepository.deleteById(cropid);
         return "Succuss";
    }


}
