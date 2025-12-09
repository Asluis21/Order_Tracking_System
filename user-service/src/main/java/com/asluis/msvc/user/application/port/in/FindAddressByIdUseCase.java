package com.asluis.msvc.user.application.port.in;

import java.util.Optional;

import com.asluis.msvc.user.domain.model.Address;

public interface FindAddressByIdUseCase {

    Optional<Address> findAddessById(Long addressId);
}
