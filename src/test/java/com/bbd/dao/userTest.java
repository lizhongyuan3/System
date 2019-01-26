package com.bbd.dao;


import com.bbd.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class userTest {
    @Autowired
    private UserDao userDao;
    @Test
    public void queryId() {
        User user=new User();
        User user1=new User();
        user.setUserId(1011);
        user.setUserPassword(123);
        user1=userDao.queryUser(user);
        System.out.println(user1);
        System.out.println("--------------------------");
    }
    @Test
    public void insertUser(){
        User user=new User();
        user.setUserId(15101118);
        user.setUserPassword(123);
        userDao.insertUser(user);
        System.out.println(user);
        System.out.println("----------------");

    }
}
