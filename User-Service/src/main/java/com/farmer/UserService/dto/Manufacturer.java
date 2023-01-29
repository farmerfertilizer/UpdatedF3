package com.farmer.UserService.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Manufacturer {


    private int manufacturerId;

    @NotNull
    @NotEmpty(message="Please enter Manufacturer Name")
    @Size(min=2,message="Manufacturer Name Should have atleast 2 characters")
    private String name;

    @NotNull
    private String password;

    @NotNull
    private int quantity;
    @NotNull
    private int amount;
    private String roles;


}
