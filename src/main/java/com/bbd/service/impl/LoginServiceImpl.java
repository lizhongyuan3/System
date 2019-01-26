package com.bbd.service.impl;

import com.bbd.dao.UserDao;
import com.bbd.entity.User;
import com.bbd.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LoginServiceImpl implements LoginService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UserDao userDao;

    @Override
    public User queryUser(User user) {
        logger.debug("开始查询用户信息");
        return userDao.queryUser(user);
    }

    @Override
    public void insertUser(User user) {
        logger.debug("开始插入用户");
       userDao.insertUser(user);
    }
}


