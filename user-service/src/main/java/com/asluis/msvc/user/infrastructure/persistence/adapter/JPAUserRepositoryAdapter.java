package com.asluis.msvc.user.infrastructure.persistence.adapter;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.asluis.msvc.user.application.port.out.UserRepositoryPort;
import com.asluis.msvc.user.domain.model.User;
import com.asluis.msvc.user.infrastructure.mapper.UserMapper;
import com.asluis.msvc.user.infrastructure.persistence.entity.UserEntity;
import com.asluis.msvc.user.infrastructure.persistence.repository.SpringDataUserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class JPAUserRepositoryAdapter implements UserRepositoryPort{

    private final SpringDataUserRepository springDataUserRepository;
    private final UserMapper userMapper;

    @Override
    public void delete(Long id) {
        springDataUserRepository.deleteById(id);
    }

    @Override
    public List<User> findAllActive() {
        return springDataUserRepository.findByActive(true)
            .stream()
            .map(userMapper::toDomain)
            .collect(Collectors.toList());
            
    }

    @Override
    public Optional<User> findById(Long id) {
        Optional<UserEntity> userEntity = springDataUserRepository.findById(id);
        if (userEntity.isEmpty()) return Optional.empty();
        return userEntity.map(userMapper::toDomain);
    }

    @Override
    public User save(User user) {
        UserEntity userEntity = userMapper.toEntity(user);
        userEntity = springDataUserRepository.save(userEntity);
        return userMapper.toDomain(userEntity);
    }
}
