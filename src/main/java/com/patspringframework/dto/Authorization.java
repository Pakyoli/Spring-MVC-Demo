package com.patspringframework.dto;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * Created by pakyo_000 on 6/4/2016.
 */
@Component
public class Authorization implements Serializable {

    private int id;
    private String username;
    private String role;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
