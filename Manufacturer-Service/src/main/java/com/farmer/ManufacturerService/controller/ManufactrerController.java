package com.farmer.ManufacturerService.controller;

import com.farmer.ManufacturerService.model.Customer;
import com.farmer.ManufacturerService.model.Manufacturer;
import com.farmer.ManufacturerService.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/manufacturer")
public class ManufactrerController {

    @Autowired
    ManufacturerService manufacturerService;
    @Autowired
    private CustomerRestConsumer consumer;
/*
    @PostMapping("/saveDetails")
    public ResponseEntity<Manufacturer> saveManufacturer(@RequestBody Manufacturer manufacturer){
        Manufacturer save=manufacturerService.saveManufacturer(manufacturer);
        return new ResponseEntity<>(save, HttpStatus.CREATED);
    }


 */
    @PutMapping("/update")
    public ResponseEntity<Manufacturer> updateManufacturer(@RequestBody Manufacturer manufacturer){
        Manufacturer update=manufacturerService.updateManufacturer(manufacturer);
        return new ResponseEntity<>(update,HttpStatus.OK);
    }

    @GetMapping("/getAllManufacturers")
    public ResponseEntity<List<Manufacturer>> getManufacturers(){
       List<Manufacturer> get= manufacturerService.getManufacturers();
       return new ResponseEntity<List<Manufacturer>>(get,HttpStatus.OK);
    }

    @GetMapping("/getmanufacturer/{manufacturerId}")
    public ResponseEntity<Optional<Manufacturer>> getManufacturer(@PathVariable Integer manufacturerId){
      Optional<Manufacturer> get= manufacturerService.getManufacturer(manufacturerId);
      return new ResponseEntity<Optional<Manufacturer>>(get,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{manufacturerid}")
    public String deleteManufacturer(@PathVariable Integer manufacturerid){
       String delete= manufacturerService.deleteManufacturer(manufacturerid);
       return  "Deleted Manufacturer";
    }
    @GetMapping("/getallcustomerdetails")
    public List<Customer> getAllCustomers(){
        return consumer.getAllCustomers();
    }
    @GetMapping("/getCustomerById/{id}")
    public Customer getCustomerById(@PathVariable int id){
        return consumer.getCustomerById(id);
    }
    @PostMapping("/addcustomer")
    public Customer  saveManufacturerCustomer(@RequestBody Customer customer){
        Manufacturer manufacturer=new Manufacturer();
        //manufacturer.setManufacturerId(customer.getCustomerId());
        manufacturer.setName(customer.getUserName());
        manufacturer.setPassword(customer.getPassword());
        manufacturer.setRoles(customer.getRole());
        manufacturerService.saveManufacturer(manufacturer);
        return consumer.saveCustomer(customer);
    }

}
