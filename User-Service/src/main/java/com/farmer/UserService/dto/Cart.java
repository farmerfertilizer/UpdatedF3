package com.farmer.UserService.dto;


import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
@Data
public class Cart {
    private List<Crops> crops;

    private List<Fertilizer> fertilizers;
    private double totalPrice;

    public Cart() {
        this.crops = new ArrayList<>();
        this.fertilizers=new ArrayList<>();
        this.totalPrice = 0.0;
    }


    public String addProduct(Crops crops,Fertilizer fertilizer) {
        this.crops.add(crops);
        this.fertilizers.add(fertilizer);
        this.totalPrice += crops.getCost() * crops.getCropsQuantity()+fertilizer.getCost()*fertilizer.getQuantity();
        return "Product Added Succesfully";
    }

    public String removeProduct(Crops crops,Fertilizer fertilizer) {
        this.crops.add(crops);
        this.fertilizers.add(fertilizer);
        this.totalPrice -= crops.getCost() * crops.getCropsQuantity()+fertilizer.getCost()*fertilizer.getQuantity();
        return "Product Removed Succesfully";
    }

}
