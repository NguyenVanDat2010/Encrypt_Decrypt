package com.example.demoencrypt.dao;

import com.example.demoencrypt.model.AppUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserMapper {
    void insert(AppUser user);

    AppUser getUserById(@Param("id") Long id);

    AppUser getByUsername(@Param("username") String username);
}
