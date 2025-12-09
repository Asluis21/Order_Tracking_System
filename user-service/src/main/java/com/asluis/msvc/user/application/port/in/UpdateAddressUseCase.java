package com.asluis.msvc.user.application.port.in;

import com.asluis.msvc.user.domain.model.Address;

public interface UpdateAddressUseCase {

    Address updateAddress(Long id, Address address);
}
