package com.farmer.UserService.controller;

import com.farmer.UserService.dto.Crops;
import com.farmer.UserService.dto.Fertilizer;
import com.farmer.UserService.dto.Manufacturer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "MANUFACTURING-SERVICE")
public interface ManufacturerController {

    @GetMapping("/manufacturer/getAllManufacturers")
    public List<Manufacturer> getManufacturers();

    @GetMapping("/crops/getAllCrops")
    public List<Crops> getAllCrops();

    @GetMapping("/fertilizer/getAllFertilizers")
    public List<Fertilizer> getAllFertilizers();

    @GetMapping("/manufacturer/getmanufacturer/{manufacturerId}")
    public Manufacturer getManufacturer(@PathVariable int manufacturerId);

    @GetMapping("/crops/getCrop/{cropid}")
    public Crops getCropsById(@PathVariable int cropId);

    @GetMapping("/fertilizer/getFertlizer/{fertilizerid}")
    public Fertilizer getFertilizerById(@PathVariable int fertilizerId);


}
