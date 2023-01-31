package com.farmer.ManufacturerService.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Fertilizer {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int fertilizerId;

    @NotNull
    @NotEmpty(message="Please enter Fertilizer Name")
    @Size(min=2,message="Fertilizer Name Should have atleast 2 characters")
    private String fertilizerName;
    @NotNull
    private Integer quantity;
    @NotNull
    private double cost;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="manufacturerId")
    private Manufacturer manufacturer;

}
