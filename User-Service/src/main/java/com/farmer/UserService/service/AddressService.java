package com.farmer.UserService.service;

import com.farmer.UserService.exception.CustomerNotFoundException;
import com.farmer.UserService.model.Address;
import com.farmer.UserService.repository.AddressRepository;
import com.farmer.UserService.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    CustomerRepository customerRepository;
    public Address addAddress(Address address, int customerid) {
        Address prd = customerRepository.findById(customerid).map(add -> {
            address.setCustomer(add);
            return addressRepository.save(address);
        }).orElseThrow(() -> new CustomerNotFoundException("Not found Customer with id = " + customerid));
        return prd;
    }
    public Address updateAddress(Address address) {
        Address addresses=new Address();
        Optional<Address> updateAddress=addressRepository.findById(address.getAddressId());
        if(updateAddress.isPresent()){
            addresses.setCity(address.getCity());
            addresses.setDistrict(address.getDistrict());
            addresses.setPincode(address.getPincode());
            addresses.setHouseNumber(address.getHouseNumber());
            addresses.setLandmark(address.getLandmark());
            addresses.setStreet(address.getStreet());
            addresses.setState(address.getState());
        }else{
            return new Address();
        }
        return  addressRepository.save(addresses);
    }

    public List<Address> getAllAddress() {
        return addressRepository.findAll();
    }

    public Address getAddressById(int addressId) {
        return addressRepository.findById(addressId).get();
    }

    public String deleteAddress(int addressId) {
        addressRepository.deleteById(addressId);
        return "Success";
    }

}
