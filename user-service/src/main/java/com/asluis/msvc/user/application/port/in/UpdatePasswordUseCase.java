package com.asluis.msvc.user.application.port.in;

public interface UpdatePasswordUseCase {

    void updatePassword(Long id, String newPassword);
}
