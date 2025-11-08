package com.asluis.msvc.user.infrastructure.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.asluis.msvc.user.domain.model.User;
import com.asluis.msvc.user.infrastructure.persistence.controller.dto.UserRequestDTO;
import com.asluis.msvc.user.infrastructure.persistence.controller.dto.UserResponseDTO;
import com.asluis.msvc.user.infrastructure.persistence.controller.dto.UserUpdateRequestDTO;
import com.asluis.msvc.user.infrastructure.persistence.entity.UserEntity;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    UserEntity toEntity(User user);

    User toDomain(UserEntity entity);

    User toDomain(UserRequestDTO dto);

    UserResponseDTO toResponseDTO(User domain);

    User toDomain(UserUpdateRequestDTO dto);
}
