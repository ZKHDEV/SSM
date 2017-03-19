package com.zkh.pojo;

import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

public class User implements Serializable {
    private Integer id;
    @NotEmpty(message="{user.email.length.error}")
    private String email;
    @NotEmpty(message="{user.password.length.error}")
    private String password;
    @NotEmpty(message="{user.username.length.error}")
    private String username;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
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
}