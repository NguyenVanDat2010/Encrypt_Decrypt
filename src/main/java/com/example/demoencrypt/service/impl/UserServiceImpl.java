package com.example.demoencrypt.service.impl;

import com.example.demoencrypt.dao.UserMapper;
import com.example.demoencrypt.model.AppUser;
import com.example.demoencrypt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public void insert(AppUser user) {
        userMapper.insert(user);
    }

    @Override
    public AppUser getUserById(Long id) {
        return userMapper.getUserById(id);
    }

    @Override
    public AppUser getUserByUsername(String username) {
        return userMapper.getByUsername(username);
    }
}
