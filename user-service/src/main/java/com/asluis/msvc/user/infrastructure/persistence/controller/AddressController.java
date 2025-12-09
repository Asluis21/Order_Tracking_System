package com.asluis.msvc.user.infrastructure.persistence.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asluis.msvc.user.application.exception.AddressNotFoundException;
import com.asluis.msvc.user.application.port.in.CreateAddressUseCase;
import com.asluis.msvc.user.application.port.in.FindAddressByIdUseCase;
import com.asluis.msvc.user.domain.model.Address;
import com.asluis.msvc.user.infrastructure.mapper.AddressMapper;
import com.asluis.msvc.user.infrastructure.persistence.controller.dto.AddressRequestDTO;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RequiredArgsConstructor
@RestController
@RequestMapping("/address")
public class AddressController {

    private final AddressMapper addressMapper;
    private final CreateAddressUseCase createAddressUseCase;
    private final FindAddressByIdUseCase findAddressByIdUseCase;

    @PostMapping("/{userId}")
    public ResponseEntity<?> save (@PathVariable Long userId, @RequestBody AddressRequestDTO dto) {
        Address model = addressMapper.toDomian(dto);
        Address savedAddress = createAddressUseCase.createAddress(userId, model);
        return ResponseEntity.ok(addressMapper.toResponseDTO(savedAddress));
    }
    
    @GetMapping("/{addressId}")
    public ResponseEntity<?> save (@PathVariable Long addressId) {
        Address foundAddress = findAddressByIdUseCase.findAddessById(addressId)
            .orElseThrow(() -> new AddressNotFoundException("Address with id " + addressId + " no found"));
        return ResponseEntity.ok(addressMapper.toResponseDTO(foundAddress));
    }

    @PatchMapping("/{addressId}")
    public ResponseEntity<?> markAsDefault(@PathVariable Long addressId){
        return null;
    }
}
