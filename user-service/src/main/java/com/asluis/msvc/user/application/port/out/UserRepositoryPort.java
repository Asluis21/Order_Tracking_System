package com.asluis.msvc.user.application.port.out;

import java.util.List;
import java.util.Optional;

import com.asluis.msvc.user.domain.model.User;

public interface UserRepositoryPort {
    
    User save(User user);
    Optional<User> findById(Long id);
    List<User> findAllActive();
    void delete(Long id);

}
