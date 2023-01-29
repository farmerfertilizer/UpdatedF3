package com.ust.app.controller;

import com.ust.app.entity.SecurityEntity;
import com.ust.app.model.*;
import com.ust.app.repositary.SecurityRepo;
import com.ust.app.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/security")
public class SecurityController  {



    @Autowired
    private SecurityService securityService;

    @Autowired
    private SecurityRepo securityRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private CustomerController customerController;

    @Autowired
    private ManufacturerController manufacturerController;

    @GetMapping("/customer")
    @PreAuthorize("hasAuthority('CUST_ROLE')")
    public ResponseEntity<List<Customer>> getCustomerInfo() {

        return  customerController.getAllCustomers();
    }

    @PostMapping("/savecustomerdata")
    public ResponseEntity<Customer> postCustomerInfo(@RequestBody Customer customer)
    {
        securityService.storePasswordDetails(customer);
       return  customerController.saveCustomer(customer);

    }
    @PutMapping("/update")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer){
        return customerController.updateCustomer(customer);
    }

    @GetMapping("/getCustomerByUserName/{name}")
    public ResponseEntity<Customer> findByUserName(@PathVariable String name){
        return customerController.findByUserName(name);
    }

    @GetMapping("/getCustomerById/{customerId}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable int customerId){
        return customerController.getCustomerById(customerId);
    }

    @DeleteMapping("/deleteCustomer/{customerId}")
    public ResponseEntity<String> deleteCustomer(@PathVariable int customerId){
        return customerController.deleteCustomer(customerId);
    }

    @GetMapping("/getCropsById/{cropId}")
    public ResponseEntity<Crops> getCropsById(@PathVariable int cropId){
        return customerController.getCropsById(cropId);
    }

    @GetMapping("/getFertilizerById/{fertilizerId}")
    public ResponseEntity<Fertilizer> getFertilizerById(@PathVariable int fertilizerId){
        return customerController.getFertilizerById(fertilizerId);
    }

    @GetMapping("/getManufacturerById/{manufacturerId}")
    public ResponseEntity<Manufacturer> getManufacturerById(@PathVariable int manufacturerId){
        return customerController.getManufacturerById(manufacturerId);
    }
/*
    @GetMapping("/getAllManufacturers")
    public ResponseEntity<List<Manufacturer>> getAllManufacturers(){
        return customerController.getAllManufacturers();
    }

 */

    @GetMapping("/getAllCrops")
    public ResponseEntity<List<Crops>> getAllCrops(){
        return customerController.getAllCrops();
    }

    @GetMapping("/getAllFertilizers")
    public ResponseEntity<List<Fertilizer>> getAllFertilizers(){
        return customerController.getAllFertilizers();
    }

    @PostMapping("/address/save/{customerid}")
    public ResponseEntity<Address> saveAddress(@RequestBody Address address, @PathVariable int customerid){
        return  customerController.saveAddress(address,customerid);
    }
    @PutMapping("/address/update")
    public ResponseEntity<Address> updateAddress(@RequestBody Address address){
        return customerController.updateAddress(address);
    }
    @GetMapping("getAddress/{addressId}")
    public ResponseEntity<Address> getAddressById(@PathVariable int addressId){
        return customerController.getAddressById(addressId);
    }

    @DeleteMapping("/deleteAddress/{addressId}")
    public ResponseEntity<String> deleteAddressById(@PathVariable int addressId){
        return customerController.deleteCustomer(addressId);
    }

    @PostMapping("/manufacturer/save")
    public ResponseEntity<Manufacturer> saveManufacturer(@RequestBody Manufacturer manufacturer){
        return manufacturerController.saveManufacturer(manufacturer);
    }
    @PutMapping("/manufacturer/update")
    public ResponseEntity<Manufacturer> updateManufacturer(@RequestBody Manufacturer manufacturer){
        return manufacturerController.updateManufacturer(manufacturer);
    }
    @GetMapping("/getAllManufacturers")
    public ResponseEntity<List<Manufacturer>> getManufacturers(){
        return manufacturerController.getManufacturers();
    }

    @DeleteMapping("/deleteManufacturer/{manufacturerId}")
    public String deleteManufacturer(@PathVariable int manufacturerId){
        return manufacturerController.deleteManufacturer(manufacturerId);
    }

    @PostMapping("/crops/save/{manufacterId}")
    public ResponseEntity<Crops> saveCrops(@PathVariable("manufacterId") int manufacterId,@RequestBody Crops crops){
        return manufacturerController.saveCrops(manufacterId,crops);
    }

    @PutMapping("/crops/update")
    public ResponseEntity<Crops> updateCrops(@RequestBody Crops crops){
        return manufacturerController.updateCrops(crops);
    }

    @GetMapping("/getCropById/{cropId}")
    public ResponseEntity<Optional<Crops>> getCropId(@PathVariable int cropId){
        return manufacturerController.getCropsById(cropId);
    }

    @DeleteMapping("/deleteCrop/{cropId}")
    public String deleteCrop(@PathVariable int cropId){
        return  manufacturerController.deleteCrops(cropId);
    }

    @PostMapping("/fertilizer/save/{manufacturerId}")
    public ResponseEntity<Fertilizer> saveFertilizer(@PathVariable("manufacterId") int manufacturerId,@RequestBody Fertilizer fertilizer){
        return manufacturerController.saveFertilizer(manufacturerId,fertilizer);
    }

    @PutMapping("/fertilizer/update")
    public ResponseEntity<Fertilizer> updateFertilizer(@RequestBody Fertilizer fertilizer){
        return manufacturerController.updateFertilizers(fertilizer);
    }

    @GetMapping("/getFertilizerByid/{fertilizerId}")
    public ResponseEntity<Optional<Fertilizer>> findFertilizerById(@PathVariable int fertilizerId){
        return manufacturerController.getFertilizerById(fertilizerId);
    }

    @DeleteMapping("/deleteferilizer/{fertilizerId}")
    public ResponseEntity<String> deleteFertlizer(@PathVariable int fertilizerId){
        return manufacturerController.deleteFertilizer(fertilizerId);
    }
}
