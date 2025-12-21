package com.asluis.msvc.user.application.port.in;

import com.asluis.msvc.user.domain.model.Address;
import com.asluis.msvc.user.infrastructure.persistence.controller.dto.AddressRequestDTO;

public interface UpdateAddressUseCase {

    Address updateAddress(Long id, AddressRequestDTO address);
}
