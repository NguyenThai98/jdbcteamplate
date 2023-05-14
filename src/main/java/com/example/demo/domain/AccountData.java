package com.example.demo.domain;

import com.example.demo.anotation.TypeJson;

import java.io.Serializable;

public class AccountData implements Serializable {

    private static final long serialVersionUID = 1L;
    @TypeJson(typeClass = Role.class)
    private Role roles;
    private int userId;
    private String username;
    private String password;
    private String email;

    @TypeJson(typeClass = ShortInfo.class)
    private ShortInfo shortInfo;

    public AccountData() {
    }

    public ShortInfo getShortInfo() {
        return shortInfo;
    }

    public void setShortInfo(ShortInfo shortInfo) {
        this.shortInfo = shortInfo;
    }

    public Role getRoles() {
        return roles;
    }

    public void setRoles(Role roles) {
        this.roles = roles;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
