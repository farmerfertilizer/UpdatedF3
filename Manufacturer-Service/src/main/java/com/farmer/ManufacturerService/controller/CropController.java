package com.farmer.ManufacturerService.controller;

import com.farmer.ManufacturerService.exception.ManufacturerNotFoundException;
import com.farmer.ManufacturerService.model.Crops;
import com.farmer.ManufacturerService.model.Fertilizer;
import com.farmer.ManufacturerService.service.CropsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/crops")
public class CropController {

    @Autowired
    CropsService cropsService;

    @PostMapping("/save/{manufacterId}")
    public ResponseEntity<Crops> saveCrops(@PathVariable("manufacterId") int manufacterId,@RequestBody Crops crops) throws ManufacturerNotFoundException {
       Crops save= cropsService.addCrops(manufacterId,crops);
       return new ResponseEntity<>(save, HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<Crops> updateCrops(@RequestBody Crops crops){
        Crops update=cropsService.updateCrop(crops);
        return new ResponseEntity<>(update,HttpStatus.OK);
    }

    @GetMapping("/getAllCrops")
    public ResponseEntity<List<Crops>> getAllCrops(){
       List<Crops> get= cropsService.getAllCrops();
       return new ResponseEntity<List<Crops>>(get,HttpStatus.OK);
    }


    @GetMapping("/getCrop/{cropId}")
    public ResponseEntity<Optional<Crops>> getCropsById(@PathVariable Integer cropId){
        Optional<Crops> get=cropsService.getCropById(cropId);
        return new ResponseEntity<Optional<Crops>>(get,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{cropId}")
    public String deleteCrops(@PathVariable Integer cropId){
        String delete=cropsService.deleteCrop(cropId);
        return "Deleted";
    }
}
