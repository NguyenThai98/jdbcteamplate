package com.example.demo.domain;

import com.example.demo.anotation.TypeJson;

import java.io.Serializable;

public class AccountData implements Serializable {

    private static final long serialVersionUID = 1L;

    private int account;
    private String username;
    private String password;
    private String email;

    @TypeJson(typeClass = Role.class)
    private Role role;

    public AccountData() {
    }

    public AccountData(int account, String username, String password, String email, Role role) {
        this.account = account;
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
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
