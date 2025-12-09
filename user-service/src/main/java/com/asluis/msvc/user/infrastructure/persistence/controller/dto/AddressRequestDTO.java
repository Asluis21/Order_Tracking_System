package com.asluis.msvc.user.infrastructure.persistence.controller.dto;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressRequestDTO {

    @Length(max = 50)
    @NotBlank
    private String street;

    @Length(max = 20)
    @NotBlank
    private String city;

    @Length(max = 20)
    @NotBlank
    private String state;

    @Length(max = 20)
    @NotBlank
    private String postalCode;

    @Length(max = 20)
    @NotBlank
    private String country;    
}
