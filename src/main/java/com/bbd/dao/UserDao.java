package com.bbd.dao;

import com.bbd.entity.User;

public interface UserDao {
    User queryUser(User user);
    void insertUser(User user);
}
