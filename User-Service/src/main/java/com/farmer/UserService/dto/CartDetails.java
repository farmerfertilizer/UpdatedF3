package com.farmer.UserService.dto;


import com.farmer.UserService.model.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartDetails {
    private Crops  crops;
    private Fertilizer fertilizer;
    private Customer customer;
}
