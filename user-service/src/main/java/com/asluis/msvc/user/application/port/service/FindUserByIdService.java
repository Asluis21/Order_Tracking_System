package com.asluis.msvc.user.application.port.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asluis.msvc.user.application.exception.UserNotFoundException;
import com.asluis.msvc.user.application.port.in.FindUserByIdUseCase;
import com.asluis.msvc.user.application.port.out.UserRepositoryPort;
import com.asluis.msvc.user.domain.model.User;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class FindUserByIdService implements FindUserByIdUseCase{

    private final UserRepositoryPort userRepositoryPort;

    @Transactional(readOnly = true)
    @Override
    public User findUserById(Long id) {

        System.out.println("service =======================");

        return userRepositoryPort.findById(id)
            .orElseThrow(()-> new UserNotFoundException("User with id " + id + " not found"));
    }
}
