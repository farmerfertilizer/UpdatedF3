package com.ust.app.controller;

import com.ust.app.model.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name="USER-SERVICE")
public interface CustomerController {

    @GetMapping("/customer/getAllCustomers")
    public ResponseEntity<List<Customer>> getAllCustomers();

    @PostMapping("/customer/save")
    public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer);

    @PutMapping("/customer/update")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer);

    @GetMapping("/customer/getCustomerByName/{name}")
    public ResponseEntity<Customer> findByUserName(@PathVariable String customer);

    @GetMapping("/customer/getCustomer/{customerId}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable int customerId);

    @DeleteMapping("/customer/delete/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable int id);

    @GetMapping("/customer/crops/getCrop/{cropid}")
    public ResponseEntity<Crops> getCropsById(@PathVariable Integer cropId);

    @GetMapping("/customer/fertilizer/getFertlizer/{fertilizerid}")
    public ResponseEntity<Fertilizer> getFertilizerById(@PathVariable Integer fertilizerId);

    @GetMapping("/customer/manufacturer/getmanufacturer/{manufacturerId}")
    public ResponseEntity<Manufacturer> getManufacturerById(@PathVariable Integer manufacturerId);

    @GetMapping("/customer/manufacturer/allManufacturers")
    public ResponseEntity<List<Manufacturer>> getAllManufacturers();

    @GetMapping("/customer/crops/allCrops")
    public ResponseEntity<List<Crops>> getAllCrops();

    @GetMapping("/customer/fertilizers/allFertilizers")
    public ResponseEntity<List<Fertilizer>> getAllFertilizers();

    @PostMapping("/address/save/{customerid}")
    public ResponseEntity<Address> saveAddress(@RequestBody Address address, @PathVariable int customerid);

    @PutMapping("/address/update")
    public ResponseEntity<Address> updateAddress(@RequestBody Address address);

    @GetMapping("/address/getAddress/{addressId}")
    public ResponseEntity<Address> getAddressById(@PathVariable int addressId);

    @DeleteMapping("/address/delete/{addressId}")
    public ResponseEntity<String> deleteAddress(@PathVariable int addressId);
}
