package com.farmer.ManufacturerService.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;

    private String firstName;
    private String lastName;

    private String email;

    private String phoneNumber;

    private String userName;
    private String password;
  //  @NotEmpty(message="Please enter your Role")
    private String role;


}
