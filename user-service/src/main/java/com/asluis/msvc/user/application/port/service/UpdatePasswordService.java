package com.asluis.msvc.user.application.port.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asluis.msvc.user.application.exception.UserNotFoundException;
import com.asluis.msvc.user.application.port.in.UpdatePasswordUseCase;
import com.asluis.msvc.user.application.port.out.PasswordEncoderPort;
import com.asluis.msvc.user.application.port.out.UserRepositoryPort;
import com.asluis.msvc.user.domain.model.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UpdatePasswordService implements UpdatePasswordUseCase{

    private final UserRepositoryPort userRepositoryPort;
    private final PasswordEncoderPort passwordEncoder;

    @Transactional
    @Override
    public void updatePassword(Long id, String newPassword) {
        
        User foundUser = userRepositoryPort.findById(id)
            .orElseThrow(()-> new UserNotFoundException("User with id " + id + " not found"));
         
        foundUser.setPassword(passwordEncoder.encode(newPassword));
        
        userRepositoryPort.save(foundUser);

    }
}
