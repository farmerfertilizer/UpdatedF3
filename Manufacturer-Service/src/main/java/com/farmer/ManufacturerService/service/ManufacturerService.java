package com.farmer.ManufacturerService.service;

import com.farmer.ManufacturerService.controller.CustomerRestConsumer;
import com.farmer.ManufacturerService.exception.ManufacturerAlreadyExistsException;
import com.farmer.ManufacturerService.model.Customer;
import com.farmer.ManufacturerService.model.Fertilizer;
import com.farmer.ManufacturerService.model.Manufacturer;
import com.farmer.ManufacturerService.repository.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ManufacturerService {

    @Autowired
    ManufacturerRepository manufacturerRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public Manufacturer saveManufacturer(Manufacturer customer) {
/*
        if (manufacturerRepository.existsByName(manufacturer.getName())) {
            throw new ManufacturerAlreadyExistsException("Manufacturer is already exist");
        }
        */

        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
       return manufacturerRepository.save(customer);
    }

    public List<Manufacturer> getManufacturers() {
        return manufacturerRepository.findAll();
    }

    public Optional<Manufacturer> getManufacturer(Integer manufacturerId) {
        return manufacturerRepository.findById(manufacturerId);
    }

    public String deleteManufacturer(Integer manufacturerId) {
     manufacturerRepository.deleteById(manufacturerId);
     return "Success";
    }

    public Manufacturer updateManufacturer(Manufacturer manufacturer) {
        Manufacturer manu=new Manufacturer();
        Optional<Manufacturer> updateManufacturer=manufacturerRepository.findById(manu.getManufacturerId());
        if(updateManufacturer.isPresent()){
            manu.setManufacturerId(updateManufacturer.get().getManufacturerId());
           // manu.setQuantity(updateManufacturer.get().getQuantity());
           // manu.setAmount(updateManufacturer.get().getAmount());
        }else{
            return new Manufacturer();
        }
        return  manufacturerRepository.save(manufacturer);
    }

}
