package com.example.timecoder.gateway.payload.timecoder;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ThemePayload {

    public ThemePayload(){}

    @JsonProperty
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
