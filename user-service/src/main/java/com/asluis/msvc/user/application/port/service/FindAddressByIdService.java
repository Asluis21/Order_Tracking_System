package com.asluis.msvc.user.application.port.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asluis.msvc.user.application.port.in.FindAddressByIdUseCase;
import com.asluis.msvc.user.application.port.out.AddressRepositoryPort;
import com.asluis.msvc.user.domain.model.Address;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class FindAddressByIdService implements FindAddressByIdUseCase{

    private final AddressRepositoryPort addressRepositoryPort;

    @Transactional(readOnly = true)
    @Override
    public Optional<Address> findAddessById(Long addressId) {
        return addressRepositoryPort.findById(addressId);
    }
}
