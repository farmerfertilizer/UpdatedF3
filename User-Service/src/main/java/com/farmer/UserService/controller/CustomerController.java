package com.farmer.UserService.controller;

import com.farmer.UserService.dto.*;
import com.farmer.UserService.model.Customer;
import com.farmer.UserService.model.EmailDetails;
import com.farmer.UserService.repository.CropRepo;
import com.farmer.UserService.repository.FertilizerRepo;
import com.farmer.UserService.service.CropService;
import com.farmer.UserService.service.CustomerService;
import com.farmer.UserService.service.EmailServiceImpl;
import com.farmer.UserService.service.FertilizerService;
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
    private EmailServiceImpl emailService;

    @Autowired
    public CustomerController(Cart cart) {
        this.cart = cart;

    }
    @Autowired
    private CustomerService customerService;

    @Autowired
    private CropService cropService;

    @Autowired
    private FertilizerService fertilizerService;

    @PostMapping("/save")
    public ResponseEntity<Customer> saveCustomer( @RequestBody Customer customer){
        Customer save = customerService.saveCustomer(customer);
        return new ResponseEntity<>(save, HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) throws Exception{
        Customer update=customerService.updateCustomer(customer);
        return new ResponseEntity<>(update,HttpStatus.OK);
    }
    @GetMapping("/getAllCustomers")
    public ResponseEntity<List<Customer>> getAllCustomers() throws  Exception{
        List<Customer> get= customerService.getAllCustomers();
        return new ResponseEntity<List<Customer>>(get,HttpStatus.OK);
    }
    @GetMapping("/getCustomerByName/{name}")
    public ResponseEntity<Optional<Customer>> findByUserName(@PathVariable String name){
        Optional<Customer> customer= customerService.getCustomerByName(name);
        return new ResponseEntity<>(customer,HttpStatus.OK);
    }

    @GetMapping("/getCustomer/{customerId}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable int customerId) throws Exception{
        Customer get=customerService.getCustomerById(customerId);
        return new ResponseEntity<Customer>(get,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable int id) throws Exception{
        String delete=customerService.deleteCustomer(id);
        return new ResponseEntity<>("Deleted",HttpStatus.OK);
    }

    @GetMapping("/addToCart/{customerId}/{cropId}/{fertilizerId}")
    public ResponseEntity<CartDetails> addToCart(@PathVariable int customerId, @PathVariable int cropId , @PathVariable int fertilizerId) throws Exception{
        CartDetails cartDetails=new CartDetails();
        cartDetails.setCartId(customerId);
        cartDetails.setCustomer( customerService.getUserById(customerId));
        cartDetails.setFertilizer(fertilizerService.getFertilizerById(fertilizerId));
        cartDetails.setCrops(cropService.getCropById(cropId));
      //  Crops crop =manufacturerController.getCropsById(cropId);
      //  Fertilizer fertilizer =manufacturerController.getFertilizerById(fertilizerid);
        cart.addProduct(cartDetails);
        return new ResponseEntity<>(cartDetails,HttpStatus.OK);
    }

    @GetMapping("/removeFromCart/{customerId}/{cropId}/{fertilizerId}")
    public ResponseEntity<String> removeFromCart(@PathVariable int customerId, @PathVariable int cropId,@PathVariable int fertilizerId) throws Exception{
        CartDetails cartDetails=new CartDetails();
        cartDetails.setCartId(customerId);
        cartDetails.setCustomer( customerService.getUserById(customerId));
        cartDetails.setFertilizer(fertilizerService.getFertilizerById(fertilizerId));
        cartDetails.setCrops(cropService.getCropById(cropId));
        cart.removeProduct(cartDetails);
        return new ResponseEntity<>("Product Removed you can check in cart",HttpStatus.OK);
    }
    @GetMapping("/cart")
    public ResponseEntity<Cart> viewCart() {
        return new ResponseEntity<>(cart,HttpStatus.OK);
    }

    @GetMapping("/crops/getCrop/{cropId}")
    public ResponseEntity<Crops> getCropsById(@PathVariable Integer cropId){
       Crops crops= manufacturerController.getCropsById(cropId);
       return new ResponseEntity<>(crops,HttpStatus.OK);
    }

    @GetMapping("/fertilizer/getFertlizer/{fertilizerId}")
    public ResponseEntity<Fertilizer> getFertilizerById(@PathVariable Integer fertilizerId){
        Fertilizer fertilizer= manufacturerController.getFertilizerById(fertilizerId);
        return new ResponseEntity<>(fertilizer,HttpStatus.OK);
    }
    @GetMapping("/manufacturer/getmanufacturer/{manufacturerId}")
    public ResponseEntity<Manufacturer> getManufacturerById(@PathVariable Integer manufacturerId){
        Manufacturer manufacturer= manufacturerController.getManufacturer(manufacturerId);
        return new ResponseEntity<>(manufacturer,HttpStatus.OK);
    }

    @GetMapping("/manufacturer/allManufacturers")
    public ResponseEntity<List<Manufacturer>> getAllManufacturers(){
        List<Manufacturer> manufacturers= manufacturerController.getManufacturers();
        return new ResponseEntity<>(manufacturers,HttpStatus.OK);
    }
    @GetMapping("/crops/allCrops")
    public ResponseEntity<List<Crops>> getAllCrops(){
        List<Crops> crops= manufacturerController.getAllCrops();
        return new ResponseEntity<>(crops,HttpStatus.OK);
    }
    @GetMapping("/fertilizers/allFertilizers")
    public ResponseEntity<List<Fertilizer>> getAllFertilizers(){
        List<Fertilizer> fertilizers= manufacturerController.getAllFertilizers();
        return new ResponseEntity<>(fertilizers,HttpStatus.OK);
    }

    @PostMapping("/manufacturer/saveCrops/{manufacturerId}")
    public ResponseEntity<Crops> saveCrops(@PathVariable int manufacturerId,@RequestBody Crops crops){
        customerService.saveCropDetails(crops);
        return manufacturerController.saveCrops(manufacturerId,crops);
    }

    @PostMapping("/manufacturer/saveFertilizer/{manufacturerId}")
    public ResponseEntity<Fertilizer> saveFertilizersByMAnufacturer(@PathVariable int manufacturerId,@RequestBody Fertilizer fertilizer){
        customerService.saveFertilizerDetails(fertilizer);
        return manufacturerController.saveFertilizerByManufacturer(manufacturerId,fertilizer);
    }






    @PostMapping("/sendMail")
    public String
    sendMail(@RequestBody EmailDetails details)
    {
        String status = emailService.sendSimpleMail(details);

        return status;
    }


    @PostMapping("/sendMailWithAttachment")
    public String sendMailWithAttachment(
            @RequestBody EmailDetails details)
    {
        String status = emailService.sendMailWithAttachment(details);

        return status;
    }
}
