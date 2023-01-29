package com.farmer.UserService.controller;

import com.farmer.UserService.dto.*;
import com.farmer.UserService.model.Customer;
import com.farmer.UserService.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private Cart cart;

    @Autowired
    ManufacturerController manufacturerController;

    @Autowired
    public CustomerController(Cart cart) {
        this.cart = cart;

    }
    @Autowired
    private CustomerService customerService;
    @PostMapping("/save")
    public ResponseEntity<Customer> saveCustomer( @RequestBody Customer customer){
        Customer save = customerService.saveCustomer(customer);
        return new ResponseEntity<>(save, HttpStatus.CREATED);
    }
    @PutMapping("/update")
    @PreAuthorize("hasAuthority('CUSTOMER')")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) throws Exception{
        Customer update=customerService.updateCustomer(customer);
        return new ResponseEntity<>(update,HttpStatus.OK);
    }
    @GetMapping("/getAllCustomers")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<List<Customer>> getAllCustomers() throws  Exception{
        List<Customer> get= customerService.getAllCustomers();
        return new ResponseEntity<List<Customer>>(get,HttpStatus.OK);
    }
    @GetMapping("/getCustomerByName/{name}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Optional<Customer>> findByUserName(@PathVariable String name){
        Optional<Customer> customer= customerService.getCustomerByName(name);
        return new ResponseEntity<>(customer,HttpStatus.OK);
    }

    @GetMapping("/getCustomer/{customerId}")
    @PreAuthorize("hasAuthority('CUSTOMER')")
    public ResponseEntity<Customer> getCustomerById(@PathVariable int customerId) throws Exception{
        Customer get=customerService.getCustomerById(customerId);
        return new ResponseEntity<Customer>(get,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('CUSTOMER')")
    public ResponseEntity<String> deleteCustomer(@PathVariable int id) throws Exception{
        String delete=customerService.deleteCustomer(id);
        return new ResponseEntity<>("Deleted",HttpStatus.OK);
    }

    @GetMapping("/addToCart/{customerId}/{cropId}/{fertilizerid}")
    @PreAuthorize("hasAuthority('CUSTOMER')")
    public ResponseEntity<CartDetails> addToCart(@PathVariable("customerId") int customerId, @PathVariable("cropId") int cropId , @PathVariable("fertilizerid") int fertilizerid) throws Exception{
        CartDetails cartDetails=new CartDetails();
        cartDetails.setCrops(manufacturerController.getCropsById(cropId));
        cartDetails.setFertilizer(manufacturerController.getFertilizerById(fertilizerid));
        cartDetails.setCustomer( customerService.getUserById(customerId));
        Crops crop =manufacturerController.getCropsById(cropId);
        Fertilizer fertilizer =manufacturerController.getFertilizerById(fertilizerid);
        cart.addProduct(crop,fertilizer);
        return new ResponseEntity<>(cartDetails,HttpStatus.OK);
    }

    @GetMapping("/removeFromCart/{cropId}/{fertilizerid}")
    @PreAuthorize("hasAuthority('CUSTOMER')")
    public ResponseEntity<String> removeFromCart(  @PathVariable("cropId") int cropId,@PathVariable("fertilizerid") int fertilizerid) throws Exception{
        Crops crop =manufacturerController.getCropsById(cropId);
        Fertilizer fertilizer =manufacturerController.getFertilizerById(fertilizerid);
        cart.removeProduct(crop,fertilizer);
        return new ResponseEntity<>("Product Removed you can check in cart",HttpStatus.OK);
    }
    @GetMapping("/cart")
    @PreAuthorize("hasAuthority('CUSTOMER')")
    public ResponseEntity<Cart> viewCart() {
        return new ResponseEntity<>(cart,HttpStatus.OK);
    }

    @GetMapping("/crops/getCrop/{cropid}")
    @PreAuthorize("hasAuthority('CUSTOMER')")
    public ResponseEntity<Crops> getCropsById(@PathVariable Integer cropId){
       Crops crops= manufacturerController.getCropsById(cropId);
       return new ResponseEntity<>(crops,HttpStatus.OK);
    }

    @GetMapping("/fertilizer/getFertlizer/{fertilizerid}")
    @PreAuthorize("hasAuthority('CUSTOMER')")
    public ResponseEntity<Fertilizer> getFertilizerById(@PathVariable Integer fertilizerId){
        Fertilizer fertilizer= manufacturerController.getFertilizerById(fertilizerId);
        return new ResponseEntity<>(fertilizer,HttpStatus.OK);
    }
    @GetMapping("/manufacturer/getmanufacturer/{manufacturerId}")
    @PreAuthorize("hasAuthority('CUSTOMER')")
    public ResponseEntity<Manufacturer> getManufacturerById(@PathVariable Integer manufacturerId){
        Manufacturer manufacturer= manufacturerController.getManufacturer(manufacturerId);
        return new ResponseEntity<>(manufacturer,HttpStatus.OK);
    }

    @GetMapping("/manufacturer/allManufacturers")
    @PreAuthorize("hasAuthority('CUSTOMER')")
    public ResponseEntity<List<Manufacturer>> getAllManufacturers(){
        List<Manufacturer> manufacturers= manufacturerController.getManufacturers();
        return new ResponseEntity<>(manufacturers,HttpStatus.OK);
    }
    @GetMapping("/crops/allCrops")
    @PreAuthorize("hasAuthority('CUSTOMER')")
    public ResponseEntity<List<Crops>> getAllCrops(){
        List<Crops> crops= manufacturerController.getAllCrops();
        return new ResponseEntity<>(crops,HttpStatus.OK);
    }
    @GetMapping("/fertilizers/allFertilizers")
    @PreAuthorize("hasAuthority('CUSTOMER')")
    public ResponseEntity<List<Fertilizer>> getAllFertilizers(){
        List<Fertilizer> fertilizers= manufacturerController.getAllFertilizers();
        return new ResponseEntity<>(fertilizers,HttpStatus.OK);
    }

}
