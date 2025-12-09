package com.asluis.msvc.user.infrastructure.persistence.controller.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDTO {

    private Long id;
    private String name;
    private String lastName;
    private String email;
    private String phoneNumber;
    private List<AddressResponseDTO> addresses;
}
