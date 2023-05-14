package com.example.demo.domain;

import java.io.Serializable;

/**
 * Date: 5/12/2023<br/>
 * Time: 5:19 PM<br/>
 */
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    private String roleName;
    private int roleCode;

    public Role() {
    }

    public Role(String roleName, int roleCode) {
        this.roleName = roleName;
        this.roleCode = roleCode;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public int getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(int roleCode) {
        this.roleCode = roleCode;
    }
}
