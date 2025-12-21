package com.asluis.msvc.user.application.port.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asluis.msvc.user.application.exception.UserNotFoundException;
import com.asluis.msvc.user.application.port.in.CreateAddressUseCase;
import com.asluis.msvc.user.application.port.out.AddressRepositoryPort;
import com.asluis.msvc.user.application.port.out.UserRepositoryPort;
import com.asluis.msvc.user.domain.model.Address;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CreateAddressService implements CreateAddressUseCase{

    private final AddressRepositoryPort addressRepositoryPort;
    private final UserRepositoryPort userRepositoryPort;

    @Transactional
    @Override
    public Address createAddress(Long userId, Address address) {

        userRepositoryPort.findById(userId)
            .orElseThrow(() -> new UserNotFoundException("User with id " + userId + " not found"));

        address.setIsDefault(false);
        address.setUserId(userId);

        return addressRepositoryPort.saveAddress(address);
    }
}
