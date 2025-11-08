package com.asluis.msvc.user.infrastructure.persistence.controller.dto;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdateRequestDTO {

    @Length(max = 50)
    @NotBlank
    private String name;

    @Length(max = 100)
    @NotBlank
    private String lastName;
    
    @Pattern(
        regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$",
        message = "Invalid email format"
    )   
    @NotBlank
    private String email;
    
    @NotBlank(message = "Phone number cannot be blank")
    @Pattern(
        regexp = "^\\+?[0-9]{7,15}$",
        message = "Phone number must be valid and may include a country code"
    )
    private String phoneNumber;
}
