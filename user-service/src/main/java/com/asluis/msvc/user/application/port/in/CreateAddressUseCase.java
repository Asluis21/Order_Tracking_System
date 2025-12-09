package com.asluis.msvc.user.application.port.in;

import com.asluis.msvc.user.domain.model.Address;

public interface CreateAddressUseCase {

    Address createAddress(Long userId, Address address);
}
