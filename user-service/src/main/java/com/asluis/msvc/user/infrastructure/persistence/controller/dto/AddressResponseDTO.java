package com.asluis.msvc.user.infrastructure.persistence.controller.dto;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressResponseDTO {

    private Long id;

    private String street;

    private String city;

    private String state;

    private String postalCode;

    private String country;

    private Boolean isDefault;

    private Long userId;
}
