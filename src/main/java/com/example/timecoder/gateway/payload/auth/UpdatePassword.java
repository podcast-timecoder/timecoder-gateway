package com.example.timecoder.gateway.payload.auth;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UpdatePassword {

    @NotBlank
    @Size(min = 6, max = 20)
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
