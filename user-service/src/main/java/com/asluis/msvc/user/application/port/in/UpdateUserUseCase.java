package com.asluis.msvc.user.application.port.in;

import com.asluis.msvc.user.domain.model.User;

public interface UpdateUserUseCase {

    User updateUser(Long id, User user);
}
