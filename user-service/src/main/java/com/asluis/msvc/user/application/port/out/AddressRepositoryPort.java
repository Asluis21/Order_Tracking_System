package com.asluis.msvc.user.application.port.out;

import java.util.List;
import java.util.Optional;

import com.asluis.msvc.user.domain.model.Address;

public interface AddressRepositoryPort {

    Address saveAddress(Address address);
    Optional<Address> findById(Long id);
    void deleteAddress(Long id);
    List<Address> findByUserId(Long userId);
    List<Address> saveAll(List<Address> addresses);
}
