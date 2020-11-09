package com.example.demoencrypt.service;

import com.example.demoencrypt.model.AppUser;

public interface UserService {
    void insert(AppUser user);
    AppUser getUserById(Long id);
    AppUser getUserByUsername(String username);
}
