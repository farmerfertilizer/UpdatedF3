package com.ust.app.service;

import com.ust.app.entity.SecurityEntity;
import com.ust.app.model.Customer;
import com.ust.app.model.Manufacturer;
import com.ust.app.repositary.SecurityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SecurityService {
    @Autowired
    SecurityRepo securityRepo;

    @Autowired
    PasswordEncoder passwordEncoder;

    public String storePasswordDetails(Customer customer)
    {
        String msg = null;
        SecurityEntity securityEntity=new SecurityEntity();
        securityEntity.setUserName(customer.getUserName());
        securityEntity.setPassword(passwordEncoder.encode(customer.getPassword()));
        securityEntity.setId(customer.getCustomerId());
        securityEntity.setRole(customer.getRole());
        if(securityRepo.findByUserName(customer.getUserName()).isPresent()){
            msg = "User Name already Exist";
        }else{
            securityRepo.save(securityEntity);
            msg = "Successfully Saved";
        }
        return msg;


    }
    public SecurityEntity storePasswordDetails(Manufacturer manufacturer)
    {
        SecurityEntity securityEntity=new SecurityEntity();
        securityEntity.setUserName(manufacturer.getName());
        securityEntity.setPassword(passwordEncoder.encode(manufacturer.getPassword()));
        securityEntity.setId(manufacturer.getManufacturerId());
        securityEntity.setRole(manufacturer.getRoles());
        return  securityRepo.save(securityEntity);


    }

}
