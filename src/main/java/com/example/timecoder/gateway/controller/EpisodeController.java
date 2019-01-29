package com.example.timecoder.gateway.controller;

import com.example.timecoder.gateway.proxy.TimecoderServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EpisodeController {

    @Autowired
    TimecoderServiceProxy timecoderServiceProxy;

    @PostMapping("/episodes")
    @PreAuthorize("hasRole('USER')")
    public Object createEpisode(){
        return timecoderServiceProxy.getAllEpisodes();
    }

}
