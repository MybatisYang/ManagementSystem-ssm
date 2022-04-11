package com.dao;

import com.pojo.User;

/**
 * @author zjzhou
 * @version 1.0
 */



public interface UserDao {
    //用户管理功能待完善
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    //上面的都是由Mybatis-Generator自动生成的

    //登录功能
    User selectByName(String username);

    //注册功能
    boolean register(User user);
}
