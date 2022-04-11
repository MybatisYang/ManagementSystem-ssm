package com.service;


import com.pojo.User;

/**
 * @author zjzhou
 * @version 1.0
 */

public interface UserService {

    boolean login(String username, String password);

    boolean register(User user);


}
