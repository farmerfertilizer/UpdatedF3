package com.farmer.UserService.dto;


import com.farmer.UserService.model.Customer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CartDetails {

    @Id
    private int cartId;
    @ManyToOne
    @JoinColumn(name = "cropId")
    private Crops  crops;


    @ManyToOne
    @JoinColumn(name = "fertilizerId")
    private Fertilizer fertilizer;


    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;
}
