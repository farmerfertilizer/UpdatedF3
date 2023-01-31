package com.ust.app.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Manufacturer {


    private int manufacturerId;

    private String name;

    private String password;

    private int quantity;

    private int amount;
    private String roles;


}
