package com.asluis.msvc.user.application.port.in;

import com.asluis.msvc.user.domain.model.User;

public interface CreateUserUseCase {
    
    User createUser(User user);
}
