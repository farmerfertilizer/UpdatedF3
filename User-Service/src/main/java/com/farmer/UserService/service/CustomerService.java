package com.farmer.UserService.service;


import com.farmer.UserService.exception.CustomerAlreadyExistsException;
import com.farmer.UserService.exception.InvalidFertilizerException;
import com.farmer.UserService.exception.handleInvalidUserException;
import com.farmer.UserService.model.Customer;
import com.farmer.UserService.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
   // public Customer addCustomer(Customer customer) {
    //    customer.setPassword(passwordEncoder.encode(customer.getPassword()));
    //    return customerRepository.save(customer);
     //   }

    public Customer saveCustomer(Customer cust) {
        Customer cu=customerRepository.findAll().stream().filter(i->i.getEmail()==cust.getEmail()).collect(Collectors.toList()).get(0);
        if (cu.getEmail().equals("")) {
            throw new CustomerAlreadyExistsException("Customer is already exist");
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
}



