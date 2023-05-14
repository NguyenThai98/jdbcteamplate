package com.example.demo.domain;

import java.io.Serializable;

/**
 * Date: 5/12/2023<br/>
 * Time: 5:19 PM<br/>
 */
public class ShortInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String username;
    private String email;
    private String role;

    public ShortInfo() {
    }

    public ShortInfo(String username, String email, String role) {
        this.username = username;
        this.email = email;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
