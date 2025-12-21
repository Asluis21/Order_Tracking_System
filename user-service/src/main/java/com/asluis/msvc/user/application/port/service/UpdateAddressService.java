package com.asluis.msvc.user.application.port.service;

import org.springframework.stereotype.Service;

import com.asluis.msvc.user.application.exception.AddressNotFoundException;
import com.asluis.msvc.user.application.port.in.UpdateAddressUseCase;
import com.asluis.msvc.user.application.port.out.AddressRepositoryPort;
import com.asluis.msvc.user.domain.model.Address;
import com.asluis.msvc.user.domain.service.AddressValidatorService;
import com.asluis.msvc.user.infrastructure.persistence.controller.dto.AddressRequestDTO;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UpdateAddressService implements UpdateAddressUseCase{

    private final AddressRepositoryPort addressRepositoryPort;
    
    private final AddressValidatorService addressValidatorService = new AddressValidatorService();

    @Override
    public Address updateAddress(Long id, AddressRequestDTO address) {
        
        Address foundAddress = addressRepositoryPort.findById(id)
            .orElseThrow(() -> new AddressNotFoundException("Address with id " + id + " not found"));

        if (addressValidatorService.verifyIsDefaulByDeleting(foundAddress)) {
            if(address.getCity() != null) foundAddress.setCity(address.getCity());
            if(address.getCountry() != null) foundAddress.setCountry(address.getCountry());
            if(address.getPostalCode() != null) foundAddress.setPostalCode(address.getPostalCode());
            if(address.getState() != null) foundAddress.setState(address.getState());
            if(address.getStreet() != null) foundAddress.setStreet(address.getStreet());
        }

        return addressRepositoryPort.saveAddress(foundAddress);
    }
}
