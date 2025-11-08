package com.asluis.msvc.user.infrastructure.adapter;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.asluis.msvc.user.application.port.out.PasswordEncoderPort;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component 
public class BCryptPasswordEncoderAdapter implements PasswordEncoderPort{

    private final PasswordEncoder passwordEncoder;

    @Override
    public String encode(String rawPassword) {
        return passwordEncoder.encode(rawPassword);
    }
}   
