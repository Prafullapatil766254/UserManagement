package com.example.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @NotBlank
    private String userName;

    @Enumerated(EnumType.STRING) // To save enums in the form of String in DB
    private Gender gender;

    @Pattern(regexp = "^\\d{10}$") // validation for 10 digits mobile no
    private String mobileNo;
}
