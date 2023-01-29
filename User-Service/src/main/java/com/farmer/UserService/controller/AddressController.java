package com.farmer.UserService.controller;

import com.farmer.UserService.model.Address;
import com.farmer.UserService.model.Customer;
import com.farmer.UserService.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;
    @PostMapping("/save/{customerid}")
    public ResponseEntity<Address> saveAddress(@RequestBody Address address, @PathVariable int customerid){
        Address save= addressService.addAddress(address,customerid);
        return new ResponseEntity<>(save, HttpStatus.CREATED);
    }
    @PutMapping("/update")
   // @PreAuthorize("hasAuthority('USER')")
    public ResponseEntity<Address> updateAddress(@RequestBody Address address){
        Address update=addressService.updateAddress(address);
        return new ResponseEntity<>(update,HttpStatus.OK);
    }

    @GetMapping("/getAllAddress")
   // @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<List<Address>> getAllAddress(){
        List<Address> get= addressService.getAllAddress();
        return new ResponseEntity<List<Address>>(get,HttpStatus.OK);
    }

    @GetMapping("/getAddress/{addressId}")
  //  @PreAuthorize("hasAuthority('USER')")
    public ResponseEntity<Address> getAddressById(@PathVariable int addressId){
        Address get=addressService.getAddressById(addressId);
        return new ResponseEntity<Address>(get,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{addressId}")
  //  @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<String> deleteAddress(@PathVariable int addressId){
        String delete=addressService.deleteAddress(addressId);
        return new ResponseEntity<>("Deleted",HttpStatus.OK);
    }
}