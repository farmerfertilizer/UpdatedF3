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
public class Crops {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer crop_id;

    @NotNull
    @NotEmpty(message="Please enter Crop Name")
    @Size(min=2,message="Crop Name Should have atleast 2 characters")
    private String crop_name;
    @NotNull
    private Integer quantity;
    @NotNull
    private Double cost;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="manufacturerId")
    private Manufacturer manufacturer;

}
