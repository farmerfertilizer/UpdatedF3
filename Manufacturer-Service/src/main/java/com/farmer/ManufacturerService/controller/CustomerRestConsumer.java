package com.farmer.ManufacturerService.controller;

import com.farmer.ManufacturerService.model.Customer;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@FeignClient(name="USER-SERVICE")
public interface CustomerRestConsumer {
    @GetMapping("/customer/getAllCustomers")
    public List<Customer> getAllCustomers();
    @GetMapping("/customer/getCustomer/{id}")
    public Customer getCustomerById(@PathVariable int id);
    @PostMapping("/customer/save")
    public Customer saveCustomer(@RequestBody Customer customer);

    @GetMapping("/customer/getCustomerByName/{name}")
    public Optional<Customer> findByUserName(String name);
}
