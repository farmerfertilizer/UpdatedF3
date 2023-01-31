package com.farmer.ManufacturerService.controller;

import com.farmer.ManufacturerService.exception.FertilizerNotFoundException;
import com.farmer.ManufacturerService.exception.ManufacturerNotFoundException;
import com.farmer.ManufacturerService.model.Crops;
import com.farmer.ManufacturerService.model.Fertilizer;
import com.farmer.ManufacturerService.service.CropsService;
import com.farmer.ManufacturerService.service.FertilizerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fertilizer")
public class FertilizerController {

    @Autowired
    FertilizerService fertilizerService;

    @PostMapping("/save/{manufacterId}")
    public ResponseEntity<Fertilizer> saveFertilizer(@PathVariable("manufacterId") int manufacterId, @RequestBody Fertilizer fertilizer) throws ManufacturerNotFoundException {
        Fertilizer save= fertilizerService.addFertilizer(manufacterId,fertilizer);
        return new ResponseEntity<>(save, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Fertilizer> updateFertilizers(@RequestBody Fertilizer fertilizer){
        Fertilizer update=fertilizerService.updateFertilizer(fertilizer);
        return new ResponseEntity<>(update,HttpStatus.OK);
    }

    @GetMapping("/getAllFertilizers")
    public ResponseEntity<List<Fertilizer>> getAllFertilizers(){
        List<Fertilizer> get= fertilizerService.getAllFertilizers();
        return new ResponseEntity<List<Fertilizer>>(get,HttpStatus.OK);
    }

    @GetMapping("/getFertlizer/{fertilizerid}")
    public ResponseEntity<Optional<Fertilizer>> getFertilizerById(@PathVariable Integer fertilizerId){
        Optional<Fertilizer> get=fertilizerService.getFertilizerById(fertilizerId);
        return new ResponseEntity<Optional<Fertilizer>>(get,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{fertilizerId}")
    public ResponseEntity<String> deleteFertilizer(@PathVariable Integer fertilizerId){
        String delete=fertilizerService.deleteFertilizer(fertilizerId);
        return new ResponseEntity<>("Deleted",HttpStatus.OK);
    }
}
