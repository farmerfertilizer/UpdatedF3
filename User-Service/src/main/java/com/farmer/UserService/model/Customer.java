package com.farmer.UserService.model;

import com.farmer.UserService.enums.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;
    @NotNull
    @NotEmpty(message="Please enter your first name")
    @Size(min=2,message="First Name Should have atleast 2 characters")
    private String firstName;
    private String lastName;
    @NotEmpty(message="Please enter your email")
    @Email(message = "Should be in correct format")
    private String email;
    @NotEmpty(message="Please enter your Mobile Number")
    @Size(max=10,message="PhoneNumber should contain 10 characters")
    @Pattern(regexp="(^$|[0-9]{10})")
    private String phoneNumber;
    @NotEmpty(message="Please enter your User Name")
    @Pattern(regexp = "[a-zA-Z0-9_.]*")
    @Size(min=2, max=10)
    private String userName;
    private String password;
    @NotEmpty(message="Please enter your Role")
    private String role;





}
