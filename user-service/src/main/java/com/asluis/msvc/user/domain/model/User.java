package com.asluis.msvc.user.domain.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class User {

    private Long id;
    private String name;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;
    private List<Address> addresses = new ArrayList<>();
    private String registrationIp;
    private String lastLoginId;
    private LocalDateTime lastLoginAt;
    private Status status;
    private Integer failLoginAttempts;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Boolean active;

    public User() {
    }
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    } 
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }    

    public String getRegistrationIp() {
        return registrationIp;
    }
    public void setRegistrationIp(String registrationIp) {
        this.registrationIp = registrationIp;
    }
    public String getLastLoginId() {
        return lastLoginId;
    }
    public void setLastLoginId(String lastLoginId) {
        this.lastLoginId = lastLoginId;
    }
    public LocalDateTime getLastLoginAt() {
        return lastLoginAt;
    }
    public void setLastLoginAt(LocalDateTime lastLoginAt) {
        this.lastLoginAt = lastLoginAt;
    }
    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
    public Integer getFailLoginAttempts() {
        return failLoginAttempts;
    }
    public void setFailLoginAttempts(Integer failLoginAttempts) {
        this.failLoginAttempts = failLoginAttempts;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", lastName=" + lastName + ", email=" + email + ", password="
                + password + ", phoneNumber=" + phoneNumber + ", registrationIp=" + registrationIp + ", lastLoginId="
                + lastLoginId + ", lastLoginAt=" + lastLoginAt + ", status=" + status + ", failLoginAttempts="
                + failLoginAttempts + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", active=" + active
                + "]";
    }
}
