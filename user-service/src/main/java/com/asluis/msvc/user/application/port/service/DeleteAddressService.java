package com.asluis.msvc.user.application.port.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asluis.msvc.user.application.port.in.DeleteAddressUseCase;
import com.asluis.msvc.user.application.port.out.AddressRepositoryPort;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DeleteAddressService implements DeleteAddressUseCase{

    private final AddressRepositoryPort addressRepositoryPort;

    @Transactional
    @Override
    public void deleteAddress(Long id) {
        addressRepositoryPort.deleteAddress(id);
    }
}
