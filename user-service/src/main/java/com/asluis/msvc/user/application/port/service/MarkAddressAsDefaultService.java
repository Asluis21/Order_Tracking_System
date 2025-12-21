package com.asluis.msvc.user.application.port.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.asluis.msvc.user.application.exception.AddressNotFoundException;
import com.asluis.msvc.user.application.port.in.MarkAddressAsDefaultUserCase;
import com.asluis.msvc.user.application.port.out.AddressRepositoryPort;
import com.asluis.msvc.user.domain.model.Address;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MarkAddressAsDefaultService implements MarkAddressAsDefaultUserCase{

    private final AddressRepositoryPort addressRepositoryPort;
    

    @Override
    public Address markAddressAsDefault(Long addressId) {
        
        Address foundAddress = addressRepositoryPort.findById(addressId)
            .orElseThrow(() -> new AddressNotFoundException("Address with Id " + addressId + " not found"));

        if(foundAddress.getIsDefault()) return foundAddress;
        
        // find user's addresses and turn to false
        List<Address> addresses = addressRepositoryPort.findByUserId(foundAddress.getUserId())
            .stream()
            .map(e -> {
                e.setIsDefault(false);
                System.out.println("========================");
                System.out.println("user id: " + e.getUserId());
                System.out.println("========================");
                return e;
            })
            .collect(Collectors.toList());

        addressRepositoryPort.saveAll(addresses);

        foundAddress.setIsDefault(true);

    
        return addressRepositoryPort.saveAddress(foundAddress);
    }

    
}
