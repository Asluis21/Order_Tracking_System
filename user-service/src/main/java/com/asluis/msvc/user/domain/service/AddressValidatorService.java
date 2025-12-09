package com.asluis.msvc.user.domain.service;

import com.asluis.msvc.user.domain.model.Address;

public class AddressValidatorService {

    public Boolean verifyIsDefaulByDeleting(Address address){

        if(address.getIsDefault()) return false;

        return true;
    }
}
