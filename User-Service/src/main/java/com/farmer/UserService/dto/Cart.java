package com.farmer.UserService.dto;


import com.farmer.UserService.repository.CartDetailsRepo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
@Data
public class Cart {
    private List<Crops> crops;

    @Autowired
    private CartDetailsRepo cartDetailsRepo;

    private List<Fertilizer> fertilizers;
    private double totalPrice;

    public Cart() {
        this.crops = new ArrayList<>();
        this.fertilizers=new ArrayList<>();
        this.totalPrice = 0.0;
    }


    public CartDetails addProduct(CartDetails cartDetails) {
        this.crops.add(cartDetails.getCrops());
        this.fertilizers.add(cartDetails.getFertilizer());
        this.totalPrice += cartDetails.getCrops().getCost() * cartDetails.getCrops().getQuantity()+cartDetails.getFertilizer().getCost()*cartDetails.getFertilizer().getQuantity();
        return cartDetailsRepo.save(cartDetails);
    }

    public String removeProduct(CartDetails cartDetails) {
        this.crops.add(cartDetails.getCrops());
        this.fertilizers.add(cartDetails.getFertilizer());
        this.totalPrice -=cartDetails.getCrops().getCost() * cartDetails.getCrops().getQuantity()+cartDetails.getFertilizer().getCost()*cartDetails.getFertilizer().getQuantity();
        cartDetailsRepo.delete(cartDetails);
        return "Product Removed Succesfully";
    }

}
