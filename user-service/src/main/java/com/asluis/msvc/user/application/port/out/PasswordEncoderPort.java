package com.asluis.msvc.user.application.port.out;

public interface PasswordEncoderPort {
    String encode(String rawPassword);
}
