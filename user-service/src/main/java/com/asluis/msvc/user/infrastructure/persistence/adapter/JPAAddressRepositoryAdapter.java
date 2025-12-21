package com.asluis.msvc.user.infrastructure.persistence.adapter;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        findById(id);

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

    @Override
    public List<Address> findByUserId(Long id) {
        return springDataAddressRepository.findByUser_id(id)
            .stream()
            .map( a -> addressMapper.toDomain(a))
            .collect(Collectors.toList());
    }

    @Override
    public List<Address> saveAll(List<Address> addresses) {
        List<AddressEntity> entities = addresses.
            stream()
            .map(d -> addressMapper.toEntity(d))
            .collect(Collectors.toList());

        return springDataAddressRepository.saveAll(entities)
            .stream()
            .map(e -> addressMapper.toDomain(e))
            .collect(Collectors.toList());
    }

    
}
