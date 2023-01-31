package com.farmer.UserService.service;


import com.farmer.UserService.dto.Crops;
import com.farmer.UserService.dto.Fertilizer;
import com.farmer.UserService.exception.EmailidAlreadyExistsException;
import com.farmer.UserService.exception.UserNameAlreadyExistsException;
import com.farmer.UserService.exception.handleInvalidUserException;
import com.farmer.UserService.model.Customer;
import com.farmer.UserService.repository.CropRepo;
import com.farmer.UserService.repository.CustomerRepository;
import com.farmer.UserService.repository.FertilizerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private CropRepo cropRepo;

    @Autowired
    private FertilizerRepo fertilizerRepo;

    /*
    public Customer saveCustomer(Customer customer) {
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        return customerRepository.save(customer);
       }

     */

      /* public Customer saveCustomer(Customer cust) throws CustomerAlreadyExistsException{
        Optional<Customer> existingEmployee = customerRepository.findByEmail(cust.getEmail());
        if (existingEmployee.isPresent()) {
            throw new CustomerAlreadyExistsException("Customer with same email id already exists!!");
        }
        cust.setPassword(passwordEncoder.encode(cust.getPassword()));
        return customerRepository.save(cust);
        }*/
      public Customer saveCustomer(Customer cust) throws EmailidAlreadyExistsException{
          Optional<Customer> existingEmail = customerRepository.findByEmail(cust.getEmail());
          Optional<Customer> existingUserName = customerRepository.findByUserName(cust.getUserName());
          if (existingEmail.isPresent()) {
              throw new EmailidAlreadyExistsException("Customer with same email id already exists!!");
          } else if (existingUserName.isPresent()){
              throw new UserNameAlreadyExistsException("Customer with same username already exists!!");
          }
          cust.setPassword(passwordEncoder.encode(cust.getPassword()));
          return customerRepository.save(cust);
      }
        public Customer updateCustomer(Customer customer) throws  Exception{
            Customer customers=new Customer();
            Optional<Customer> updateCustomer=customerRepository.findById(customer.getCustomerId());
            if(updateCustomer.isPresent()){
                customers.setFirstName(customer.getFirstName());
                customers.setLastName( customer.getLastName());
                customers.setEmail(customer.getEmail());
                customers.setPhoneNumber(customer.getPhoneNumber());
                customers.setUserName(customer.getUserName());
                customers.setPassword(customer.getPassword());
                customers.setRole(updateCustomer.get().getRole());
            }else{
                return new Customer();
            }
            return   customerRepository.save(customers);
        }

        public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
        }

        public Customer getCustomerById(int id) {
        return customerRepository.findById(id).get();
        }

        public String deleteCustomer(int id) {
            customerRepository.deleteById(id);
            return "Success";
        }


    public Customer getUserById(int customerId) {
       return customerRepository.findById(customerId).orElseThrow(()-> new handleInvalidUserException("Not found Farmer with id = " + customerId));
    }


    public Optional<Customer> getCustomerByName(String name) {
        return customerRepository.findByUserName(name);
    }

    public Crops saveCropDetails(Crops crops) {
        Crops crop=new Crops();
        crop.setCropId(crops.getCropId());
        crop.setCropName(crops.getCropName());
        crop.setQuantity(crops.getQuantity());
        crop.setCost(crops.getCost());

      return  cropRepo.save(crop);
    }

    public Fertilizer saveFertilizerDetails(Fertilizer fertilizers) {
           Fertilizer fertilizer=new Fertilizer();
           fertilizer.setFertilizerId(fertilizers.getFertilizerId());
           fertilizer.setFertilizerName(fertilizers.getFertilizerName());
           fertilizer.setQuantity(fertilizers.getQuantity());
           fertilizers.setCost(fertilizers.getCost());

           return fertilizerRepo.save(fertilizer);
    }
}



