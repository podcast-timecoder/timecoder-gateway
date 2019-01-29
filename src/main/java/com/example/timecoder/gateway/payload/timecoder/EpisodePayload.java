package com.example.timecoder.gateway.payload.timecoder;

import java.time.Instant;

public class EpisodePayload {
    private String name;
    private boolean isStarted;
    private Instant startTime;

    public EpisodePayload() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isStarted() {
        return isStarted;
    }

    public void setStarted(boolean started) {
        isStarted = started;
    }

    public Instant getStartTime() {
        return startTime;
    }

    public void setStartTime(Instant startTime) {
        this.startTime = startTime;
    }
}