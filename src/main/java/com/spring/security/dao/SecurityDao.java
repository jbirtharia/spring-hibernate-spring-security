package com.spring.security.dao;

import com.spring.security.entity.Users;

public interface SecurityDao {

    public Users loadUserByUsername(String username);
}
