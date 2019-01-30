package com.example.timecoder.gateway.payload.auth;

import java.util.List;

public class UserSummary {
    private Long id;
    private String username;
    private String name;
    private boolean isPriviledged;

    public UserSummary(Long id, String username, String name) {
        this.id = id;
        this.username = username;
        this.name = name;
    }

    public boolean isPriviledged() {
        return isPriviledged;
    }

    public void setPriviledged(boolean priviledged) {
        isPriviledged = priviledged;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
