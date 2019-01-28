package com.timecoder.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class AppUser {

    public AppUser(String email, String password, String role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }

    @GeneratedValue
    @Id
    private long id;
    private String email;
    private String password;
    private String role;
}
