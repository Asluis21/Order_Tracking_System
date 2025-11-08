package com.asluis.msvc.user.application.port.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asluis.msvc.user.application.port.in.CreateUserUseCase;
import com.asluis.msvc.user.application.port.out.PasswordEncoderPort;
import com.asluis.msvc.user.application.port.out.UserRepositoryPort;
import com.asluis.msvc.user.domain.model.Status;
import com.asluis.msvc.user.domain.model.User;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CreateUserService implements CreateUserUseCase{

    private final UserRepositoryPort userRepositoryPort;
    private final PasswordEncoderPort passwordEncoder;


    @Transactional
    @Override
    public User createUser(User user) {
        user.setStatus(Status.ACTIVE);
        user.setFailLoginAttempts(0);
        user.setCreatedAt(LocalDateTime.now());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setActive(true);
        return userRepositoryPort.save(user);
    }
}
