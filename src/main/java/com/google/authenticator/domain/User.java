package com.google.authenticator.domain;

/**
 * @Author: Gaoyp
 * @Description:
 * @Date: Create in 下午2:20 2018/2/28
 * @Modified By:
 */
public class User {

    private Integer id;
    private String username;
    private String password;
    private String secret;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(Integer id, String username, String password, String secret) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.secret = secret;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }
}
