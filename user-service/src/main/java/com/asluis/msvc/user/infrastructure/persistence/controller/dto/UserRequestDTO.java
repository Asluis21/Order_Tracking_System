package com.asluis.msvc.user.infrastructure.persistence.controller.dto;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDTO {

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
    
    /**
     * At least one digit
     * One lowercase letter
     * One uppercase letter
     * One special character
     * Minimum of 8 characters
     */
    @NotBlank(message = "Password cannot be blank")
    @Pattern(
        regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#\\$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>/?]).{8,}$",
        message = "Password must be at least 8 characters long and include uppercase, lowercase, number, and special character"
    )
    private String password;
    
    @NotBlank(message = "Phone number cannot be blank")
    @Pattern(
        regexp = "^\\+?[0-9]{7,15}$",
        message = "Phone number must be valid and may include a country code"
    )
    private String phoneNumber;
}
