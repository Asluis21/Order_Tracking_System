package com.asluis.msvc.user.infrastructure.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import com.asluis.msvc.user.domain.model.Address;
import com.asluis.msvc.user.infrastructure.persistence.controller.dto.AddressRequestDTO;
import com.asluis.msvc.user.infrastructure.persistence.controller.dto.AddressResponseDTO;
import com.asluis.msvc.user.infrastructure.persistence.entity.AddressEntity;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AddressMapper {

    @Mapping(target = "user.id", source = "userId") 
    AddressEntity toEntity(Address address);

    @Mapping(target = "userId", source = "user.id") 
    Address toDomain(AddressEntity entity);
    
    @Mapping(target = "userId", ignore = true)
    Address toDomian(AddressRequestDTO dto);

    // @Mapping(target = "userId", source = "user")
    AddressResponseDTO toResponseDTO(Address address);

    // @Mapping(target = "userId", source = "user")
    AddressResponseDTO toDto(AddressEntity entity);
}
