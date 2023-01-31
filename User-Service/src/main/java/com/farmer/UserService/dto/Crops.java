package com.farmer.UserService.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "crop")
public class Crops {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cropId")
    private Integer cropId;

    private String cropName;

    private Double cost;

    private Integer quantity;
}
