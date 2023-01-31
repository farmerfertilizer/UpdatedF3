package com.ust.app.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Crops {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer crop_id;

    private String crop_name;

    private Double cost;

    private Integer cropsQuantity;
}
