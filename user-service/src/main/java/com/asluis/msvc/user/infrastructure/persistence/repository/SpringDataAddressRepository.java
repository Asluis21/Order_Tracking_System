package com.asluis.msvc.user.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asluis.msvc.user.infrastructure.persistence.entity.AddressEntity;

public interface SpringDataAddressRepository extends JpaRepository<AddressEntity, Long>{

}
