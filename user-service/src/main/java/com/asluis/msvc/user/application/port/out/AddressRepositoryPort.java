package com.asluis.msvc.user.application.port.out;

import java.util.Optional;

import com.asluis.msvc.user.domain.model.Address;

public interface AddressRepositoryPort {

    Address saveAddress(Address address);
    Optional<Address> findById(Long id);
    void deleteAddress(Long id);
}
