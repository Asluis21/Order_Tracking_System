package com.asluis.msvc.user.application.port.in;

import com.asluis.msvc.user.domain.model.Address;

public interface MarkAddressAsDefaultUserCase {

    public Address markAddressAsDefault(Long addressId);
}
