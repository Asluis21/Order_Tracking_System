package com.asluis.msvc.user.infrastructure.persistence.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asluis.msvc.user.application.port.in.CreateUserUseCase;
import com.asluis.msvc.user.application.port.in.DeleteUserUseCase;
import com.asluis.msvc.user.application.port.in.FindUserByIdUseCase;
import com.asluis.msvc.user.application.port.in.UpdatePasswordUseCase;
import com.asluis.msvc.user.application.port.in.UpdateUserUseCase;
import com.asluis.msvc.user.domain.model.User;
import com.asluis.msvc.user.infrastructure.mapper.UserMapper;
import com.asluis.msvc.user.infrastructure.persistence.controller.dto.UserRequestDTO;
import com.asluis.msvc.user.infrastructure.persistence.controller.dto.UserResponseDTO;
import com.asluis.msvc.user.infrastructure.persistence.controller.dto.UserUpdateRequestDTO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;




@RequiredArgsConstructor
@RequestMapping("/user")
@RestController 
public class UserController {

    private final CreateUserUseCase createUserUseCase;
    // private final DeleteUserUseCase deleteUserUseCase;
    private final UpdatePasswordUseCase updatePasswordUseCase;
    private final UpdateUserUseCase updateUserUseCase;
    private final FindUserByIdUseCase findUserByIdUseCase;
    private final UserMapper userMapper;
    
    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody UserRequestDTO dto, HttpServletRequest request) {
        
        String clientIp = getClientId(request);
        
        User user = userMapper.toDomain(dto);
        user.setRegistrationIp(clientIp);

        user = createUserUseCase.createUser(user);

        UserResponseDTO userResponseDTO = userMapper.toResponseDTO(user);
        
        return ResponseEntity.ok(userResponseDTO);
    }

    private String getClientId(HttpServletRequest request){
        String xfHeader = request.getHeader("X-Forwarded-For");
        return xfHeader == null ? request.getRemoteAddr() : xfHeader.split(",")[0];
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {

        if (id == 0) return ResponseEntity.notFound().build();
        User found = findUserByIdUseCase.findUserById(id);
        
        return ResponseEntity.ok(userMapper.toResponseDTO(found));
    }

    
    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, @Valid @RequestBody UserUpdateRequestDTO dto) {
        if(id == 0) return ResponseEntity.notFound().build();

        User userToUpdate = userMapper.toDomain(dto);
        User updatedUser = updateUserUseCase.updateUser(id, userToUpdate);
        return ResponseEntity.ok(userMapper.toResponseDTO(updatedUser));
    }

    @PatchMapping("update/password/{id}")
    public ResponseEntity<?> updatePassword(@PathVariable Long id, @RequestBody String newPassword) {
        if(id == 0) return ResponseEntity.notFound().build();

        updatePasswordUseCase.updatePassword(id, newPassword);
        return ResponseEntity.ok("Your password has changed");
    }

}
