package com.farmer.UserService.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Fertilizer {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "fertilizerId")
    private int fertilizerId;
    private String fertilizerName;
    private double cost;

    private Integer quantity;


}
