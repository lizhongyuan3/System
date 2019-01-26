package com.bbd.service;

import com.bbd.entity.User;

public interface LoginService {
    User queryUser(User user);
    void insertUser(User user);
}
