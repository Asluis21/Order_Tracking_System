package com.asluis.msvc.user.application.port.service;

import org.springframework.stereotype.Service;

import com.asluis.msvc.user.application.port.in.DeleteUserUseCase;
import com.asluis.msvc.user.application.port.out.UserRepositoryPort;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DeleteUserService implements DeleteUserUseCase{

    private final UserRepositoryPort userRepositoryPort;

    @Override
    public void deleteUser(Long id) {
        userRepositoryPort.delete(id);;
    }
}
