package com.asluis.msvc.user.application.port.in;

import com.asluis.msvc.user.domain.model.User;

public interface FindUserByIdUseCase {

    User findUserById(Long id);
}
