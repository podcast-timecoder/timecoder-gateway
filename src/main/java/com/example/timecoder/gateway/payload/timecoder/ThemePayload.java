package com.example.timecoder.gateway.payload.timecoder;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ThemePayload {

    public ThemePayload(){}

    @JsonProperty
    private String title;
    @JsonProperty
    private String timecode;

    public String getTimecode() {
        return timecode;
    }

    public void setTimecode(String timecode) {
        this.timecode = timecode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
