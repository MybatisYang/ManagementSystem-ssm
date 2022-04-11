package com.pojo;

/**
 * @author zjzhou
 * @version 1.0
 */


public class User {
    private Integer user_id;

    private String password;

    private String username;

    public Integer getId() {

        return user_id;
    }

    public void setId(Integer id) {
        this.user_id = id;
    }

    public String getPassword() {

        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", username='" + username + '\'' +
                ", password=" + password +
                '}';
    }
}
