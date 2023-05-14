package com.example.demo.domain;

import java.io.Serializable;

public class AccountData2 implements Serializable {

    public static final long serialVersionUID = 1L;

    public int account;
    public String username;
    public String password;
    public String email;

    public AccountData2() {
    }

    public AccountData2(int account, String username, String password, String email) {
        this.account = account;
        this.username = username;
        this.password = password;
        this.email = email;
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
