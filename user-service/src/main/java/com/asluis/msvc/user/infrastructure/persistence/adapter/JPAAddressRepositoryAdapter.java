package com.asluis.msvc.user.infrastructure.persistence.adapter;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.asluis.msvc.user.application.port.out.AddressRepositoryPort;
import com.asluis.msvc.user.domain.model.Address;
import com.asluis.msvc.user.infrastructure.mapper.AddressMapper;
import com.asluis.msvc.user.infrastructure.persistence.entity.AddressEntity;
import com.asluis.msvc.user.infrastructure.persistence.entity.UserEntity;
import com.asluis.msvc.user.infrastructure.persistence.repository.SpringDataAddressRepository;
import com.asluis.msvc.user.infrastructure.persistence.repository.SpringDataUserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class JPAAddressRepositoryAdapter implements AddressRepositoryPort{

    private final SpringDataAddressRepository springDataAddressRepository;
    private final SpringDataUserRepository springDataUserRepository;


    private final AddressMapper addressMapper;

    @Override
    public void deleteAddress(Long id) {
        springDataAddressRepository.deleteById(id);
    }

    @Override
    public Optional<Address> findById(Long id) {       
        Optional<AddressEntity> foundAddress = springDataAddressRepository.findById(id);

        if(foundAddress.isPresent()) return Optional.of(addressMapper.toDomain(foundAddress.get()));
        return Optional.empty();
    }

    @Override
    public Address saveAddress(Address address) {
        AddressEntity entity = addressMapper.toEntity(address);

        
        UserEntity userRef = springDataUserRepository.getReferenceById(address.getUserId());
        entity.setUser(userRef);


        entity = springDataAddressRepository.save(entity);
        return addressMapper.toDomain(entity);
    }
}
