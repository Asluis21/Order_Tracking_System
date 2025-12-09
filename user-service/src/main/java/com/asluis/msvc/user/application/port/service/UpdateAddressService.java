package com.asluis.msvc.user.application.port.service;

import org.springframework.stereotype.Service;

import com.asluis.msvc.user.application.exception.AddressNotFoundException;
import com.asluis.msvc.user.application.port.in.UpdateAddressUseCase;
import com.asluis.msvc.user.application.port.out.AddressRepositoryPort;
import com.asluis.msvc.user.domain.model.Address;
import com.asluis.msvc.user.domain.service.AddressValidatorService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UpdateAddressService implements UpdateAddressUseCase{

    private AddressRepositoryPort addressRepositoryPort;
    
    private final AddressValidatorService addressValidatorService = new AddressValidatorService();

    @Override
    public Address updateAddress(Long id, Address address) {
        
        Address foundAddress = addressRepositoryPort.findById(id)
            .orElseThrow(() -> new AddressNotFoundException("Address with id " + id + " not found"));

        if (addressValidatorService.verifyIsDefaulByDeleting(foundAddress)) {
            if(address.getCity() != null) address.setCity(address.getCity());
            if(address.getCountry() != null) address.setCountry(address.getCountry());
            if(address.getPostalCode() != null) address.setPostalCode(address.getPostalCode());
            if(address.getState() != null) address.setState(address.getState());
            if(address.getStreet() != null) address.setState(address.getStreet());
        }

        return addressRepositoryPort.saveAddress(foundAddress);
    }
}
