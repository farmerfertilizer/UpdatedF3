package com.ust.app.controller;

import com.ust.app.model.Crops;
import com.ust.app.model.Fertilizer;
import com.ust.app.model.Manufacturer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "MANUFACTURING-SERVICE")
public interface ManufacturerController {

    @PostMapping("/manufacturer/saveDetails")
    public ResponseEntity<Manufacturer> saveManufacturer(@RequestBody Manufacturer manufacturer);

    @PutMapping("/manufacturer/update")
    public ResponseEntity<Manufacturer> updateManufacturer(@RequestBody Manufacturer manufacturer);
    @GetMapping("/manufacturer/getAllManufacturers")
    public ResponseEntity<List<Manufacturer>> getManufacturers();

    @GetMapping("/manufacturer/getmanufacturer/{manufacturerId}")
    public ResponseEntity<Optional<Manufacturer>> getManufacturer(@PathVariable Integer manufacturerId);

    @DeleteMapping("/manufacturer/delete/{manufacturerid}")
    public String deleteManufacturer(@PathVariable Integer manufacturerid);

    @PostMapping("/crops/save/{manufacterId}")
    public ResponseEntity<Crops> saveCrops(@PathVariable("manufacterId") int manufacterId, @RequestBody Crops crops);

    @PutMapping("/crops/update")
    public ResponseEntity<Crops> updateCrops(@RequestBody Crops crops);

    @GetMapping("/crops/getCrop/{cropid}")
    public ResponseEntity<Optional<Crops>> getCropsById(@PathVariable Integer cropid);

    @DeleteMapping("/crops/delete/{cropid}")
    public String deleteCrops(@PathVariable Integer cropid);

    @PostMapping("/fertilizer/save/{manufacterId}")
    public ResponseEntity<Fertilizer> saveFertilizer(@PathVariable("manufacterId") int manufacterId, @RequestBody Fertilizer fertilizer);
    @PutMapping("/fertilizer/update")
    public ResponseEntity<Fertilizer> updateFertilizers(@RequestBody Fertilizer fertilizer);
    @GetMapping("/fertilizer/getFertlizer/{fertilizerid}")
    public ResponseEntity<Optional<Fertilizer>> getFertilizerById(@PathVariable Integer fertilizerid);
    @DeleteMapping("/fertilizer/delete/{fertilizerId}")
    public ResponseEntity<String> deleteFertilizer(@PathVariable Integer fertilizerId);
}
