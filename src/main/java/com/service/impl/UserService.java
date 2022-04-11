package com.service.impl;

import com.dao.UserDao;
import com.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zjzhou
 * @version 1.0
 */


@Service
public class UserService {
    @Autowired
    UserDao userDao;
    //登录方法的实现,从jsp页面获取username与password
    public boolean login(String username, String password) {
        //调用DAO层
        User user = userDao.selectByName(username);
        if (user != null) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password))
                return true;
        }
        return false;
    }
    //注册方法的实现,从jsp页面获取username  password
    public boolean register(User user) {
        //调用DAO层
        return userDao.register(user);

    }
}
