package com.asluis.msvc.user.application.port.service;

import org.springframework.stereotype.Service;

import com.asluis.msvc.user.application.exception.AddressNotFoundException;
import com.asluis.msvc.user.application.port.in.MarkAddressAsDefaultUserCase;
import com.asluis.msvc.user.application.port.out.AddressRepositoryPort;
import com.asluis.msvc.user.application.port.out.UserRepositoryPort;
import com.asluis.msvc.user.domain.model.Address;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MarkAddressAsDefaultService implements MarkAddressAsDefaultUserCase{

    private final AddressRepositoryPort addressRepositoryPort;
    private final UserRepositoryPort userRepositoryPort;

    @Override
    public Address markAddressAsDefault(Long addressId) {
        
        Address foundAddress = addressRepositoryPort.findById(addressId)
            .orElseThrow(() -> new AddressNotFoundException("Address with Id " + addressId + " not found"));


        foundAddress.setIsDefault(true);

        

        return addressRepositoryPort.saveAddress(foundAddress);
    }

    
}
