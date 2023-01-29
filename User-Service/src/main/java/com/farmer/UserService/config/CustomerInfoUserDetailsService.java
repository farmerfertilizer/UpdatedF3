package com.farmer.UserService.config;

import com.farmer.UserService.model.Customer;
import com.farmer.UserService.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class CustomerInfoUserDetailsService implements UserDetailsService {

    @Autowired
    private CustomerRepository repository;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        Optional<Customer> userInfo = repository.findByUserName(name);
        return userInfo.map(CustomerInfoUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("user not found " + name));
    }
}
