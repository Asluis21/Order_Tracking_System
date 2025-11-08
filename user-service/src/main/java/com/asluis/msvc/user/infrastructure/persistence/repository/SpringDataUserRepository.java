package com.asluis.msvc.user.infrastructure.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asluis.msvc.user.infrastructure.persistence.entity.UserEntity;

public interface SpringDataUserRepository extends JpaRepository<UserEntity, Long>{

    List<UserEntity> findByActive(Boolean active);
}
