package com.ust.app.controller;

import com.ust.app.entity.SecurityEntity;
import com.ust.app.model.*;
import com.ust.app.repositary.SecurityRepo;
import com.ust.app.service.SecurityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger log = LoggerFactory.getLogger(SecurityController.class);

    @GetMapping("/customer")
    @PreAuthorize("hasAuthority('USER') " + "|| hasAuthority('ADMIN')")
    public ResponseEntity<List<Customer>> getCustomerInfo() {
        log.info(customerController.getAllCustomers().toString());
        return  customerController.getAllCustomers();
    }

    @PostMapping("/savecustomerdata")
    public ResponseEntity<Customer> postCustomerInfo(@RequestBody Customer customer)
    {
        String msg = securityService.storePasswordDetails(customer);
        log.info(msg);
        log.info(customerController.saveCustomer(customer).toString());
       return  customerController.saveCustomer(customer);

    }
    @PutMapping("/update")
    @PreAuthorize("hasAuthority('USER') " + "|| hasAuthority('ADMIN')")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer){
        log.info(customerController.updateCustomer(customer).toString());
        return customerController.updateCustomer(customer);
    }

    @GetMapping("/getCustomerByUserName/{name}")
    @PreAuthorize("hasAuthority('USER') " + "|| hasAuthority('ADMIN')")
    public ResponseEntity<Customer> findByUserName(@PathVariable String name){
        log.info(customerController.findByUserName(name).toString());
        return customerController.findByUserName(name);
    }

    @GetMapping("/getCustomerById/{customerId}")
    @PreAuthorize("hasAuthority('USER') " + "|| hasAuthority('ADMIN')")
    public ResponseEntity<Customer> getCustomerById(@PathVariable int customerId){
        log.info(customerController.getCustomerById(customerId).toString());
        return customerController.getCustomerById(customerId);
    }

    @DeleteMapping("/deleteCustomer/{customerId}")
    @PreAuthorize("hasAuthority('USER') " + "|| hasAuthority('ADMIN')")
    public ResponseEntity<String> deleteCustomer(@PathVariable int customerId){
        log.info(customerController.deleteCustomer(customerId).toString());
        return customerController.deleteCustomer(customerId);
    }

    @GetMapping("/getCropsById/{cropId}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Crops> getCropsById(@PathVariable int cropId){
        log.info(customerController.getCropsById(cropId).toString());
        return customerController.getCropsById(cropId);
    }

    @GetMapping("/getFertilizerById/{fertilizerId}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Fertilizer> getFertilizerById(@PathVariable int fertilizerId){
        log.info(customerController.getFertilizerById(fertilizerId).toString());
        return customerController.getFertilizerById(fertilizerId);
    }

    @GetMapping("/getManufacturerById/{manufacturerId}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Manufacturer> getManufacturerById(@PathVariable int manufacturerId){
        log.info(customerController.getManufacturerById(manufacturerId).toString());
        return customerController.getManufacturerById(manufacturerId);
    }
/*
    @GetMapping("/getAllManufacturers")
    public ResponseEntity<List<Manufacturer>> getAllManufacturers(){
        return customerController.getAllManufacturers();
    }

 */

    @GetMapping("/getAllCrops")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<List<Crops>> getAllCrops(){
        log.info(customerController.getAllCrops().toString());
        return customerController.getAllCrops();
    }

    @GetMapping("/getAllFertilizers")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<List<Fertilizer>> getAllFertilizers(){
        log.info(customerController.getAllFertilizers().toString());
        return customerController.getAllFertilizers();
    }

    @PostMapping("/address/save/{customerId}")
    public ResponseEntity<Address> saveAddress(@RequestBody Address address, @PathVariable int customerId){
        log.info(customerController.saveAddress(address,customerId).toString());
        return  customerController.saveAddress(address,customerId);
    }
    @PutMapping("/address/update")
    @PreAuthorize("hasAuthority('USER') " + "|| hasAuthority('ADMIN')")
    public ResponseEntity<Address> updateAddress(@RequestBody Address address){
        log.info(customerController.updateAddress(address).toString());
        return customerController.updateAddress(address);
    }
    @GetMapping("getAddress/{addressId}")
    @PreAuthorize("hasAuthority('USER') " + "|| hasAuthority('ADMIN')")
    public ResponseEntity<Address> getAddressById(@PathVariable int addressId){
        log.info(customerController.getAddressById(addressId).toString());
        return customerController.getAddressById(addressId);
    }

    @DeleteMapping("/deleteAddress/{addressId}")
    @PreAuthorize("hasAuthority('USER') " + "|| hasAuthority('ADMIN')")
    public ResponseEntity<String> deleteAddressById(@PathVariable int addressId){
        log.info(customerController.deleteCustomer(addressId).toString());
        return customerController.deleteCustomer(addressId);
    }

    @PostMapping("/manufacturer/save")
    public ResponseEntity<Customer> saveManufacturer(@RequestBody Customer customer){
        String msg = securityService.storePasswordDetails(customer);
        log.info(msg);
        log.info(manufacturerController.saveManufacturerCustomer(customer).toString());
        return manufacturerController.saveManufacturerCustomer(customer);
    }
    @PutMapping("/manufacturer/update")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Manufacturer> updateManufacturer(@RequestBody Manufacturer manufacturer){
        log.info(manufacturerController.updateManufacturer(manufacturer).toString());
        return manufacturerController.updateManufacturer(manufacturer);
    }
    @GetMapping("/getAllManufacturers")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<List<Manufacturer>> getManufacturers(){
        log.info(manufacturerController.getManufacturers().toString());
        return manufacturerController.getManufacturers();
    }

    @DeleteMapping("/deleteManufacturer/{manufacturerId}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String deleteManufacturer(@PathVariable int manufacturerId){
        log.info(manufacturerController.deleteManufacturer(manufacturerId));
        return manufacturerController.deleteManufacturer(manufacturerId);
    }

    @PostMapping("/crops/save/{manufacterId}")
    public ResponseEntity<Crops> saveCrops(@PathVariable("manufacterId") int manufacterId,@RequestBody Crops crops){
        log.info(manufacturerController.saveCrops(manufacterId,crops).toString());
        return manufacturerController.saveCrops(manufacterId,crops);
    }

    @PutMapping("/crops/update")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Crops> updateCrops(@RequestBody Crops crops){
        log.info(manufacturerController.updateCrops(crops).toString());
        return manufacturerController.updateCrops(crops);
    }

    @GetMapping("/getCropById/{cropId}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Optional<Crops>> getCropId(@PathVariable int cropId){
        log.info(manufacturerController.getCropsById(cropId).toString());
        return manufacturerController.getCropsById(cropId);
    }

    @DeleteMapping("/deleteCrop/{cropId}")
    @PreAuthorize("hasAuthority('ADMIN')")

    public String deleteCrop(@PathVariable int cropId){
        log.info(manufacturerController.deleteCrops(cropId));
        return  manufacturerController.deleteCrops(cropId);
    }

    @PostMapping("/fertilizer/save/{manufacturerId}")
    public ResponseEntity<Fertilizer> saveFertilizer(@PathVariable("manufacterId") int manufacturerId,@RequestBody Fertilizer fertilizer){
        log.info(manufacturerController.saveFertilizer(manufacturerId,fertilizer).toString());
        return manufacturerController.saveFertilizer(manufacturerId,fertilizer);
    }

    @PutMapping("/fertilizer/update")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Fertilizer> updateFertilizer(@RequestBody Fertilizer fertilizer){
        log.info(manufacturerController.updateFertilizers(fertilizer).toString());
        return manufacturerController.updateFertilizers(fertilizer);
    }

    @GetMapping("/getFertilizerByid/{fertilizerId}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Optional<Fertilizer>> findFertilizerById(@PathVariable int fertilizerId){
        log.info(manufacturerController.getFertilizerById(fertilizerId).toString());
        return manufacturerController.getFertilizerById(fertilizerId);
    }

    @DeleteMapping("/deleteferilizer/{fertilizerId}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<String> deleteFertlizer(@PathVariable int fertilizerId){
        log.info(manufacturerController.deleteFertilizer(fertilizerId).toString());
        return manufacturerController.deleteFertilizer(fertilizerId);
    }
}
