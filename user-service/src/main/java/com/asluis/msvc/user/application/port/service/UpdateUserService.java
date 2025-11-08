package com.asluis.msvc.user.application.port.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asluis.msvc.user.application.exception.UserNotFoundException;
import com.asluis.msvc.user.application.port.in.UpdateUserUseCase;
import com.asluis.msvc.user.application.port.out.UserRepositoryPort;
import com.asluis.msvc.user.domain.model.User;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UpdateUserService implements UpdateUserUseCase{

    private final UserRepositoryPort userRepositoryPort;
    
    @Transactional
    @Override
    public User updateUser(Long id, User user) {
        
        User foundUser = userRepositoryPort.findById(id)
            .orElseThrow(() -> new UserNotFoundException("User with id " + id + " not found"));

        if(user.getEmail() != null) foundUser.setEmail(user.getEmail());
        if(user.getName() != null) foundUser.setName(user.getName());
        if(user.getLastName() != null) foundUser.setLastName(user.getLastName());
        if(user.getPhoneNumber() != null) foundUser.setPhoneNumber(user.getPhoneNumber());

        return userRepositoryPort.save(user);
    }

}
