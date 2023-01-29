package com.farmer.ManufacturerService.config;

import com.farmer.ManufacturerService.controller.CustomerRestConsumer;
import com.farmer.ManufacturerService.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class ManufacturerInfoUserDetailsService implements UserDetailsService {

    @Autowired
    private CustomerRestConsumer repository;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        Optional<Customer> userInfo = repository.findByUserName(name);
        return userInfo.map(ManufacturerInfoUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("user not found " + name));
    }
}
