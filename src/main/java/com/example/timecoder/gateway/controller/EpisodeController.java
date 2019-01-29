package com.example.timecoder.gateway.controller;

import com.example.timecoder.gateway.payload.timecoder.EpisodePayload;
import com.example.timecoder.gateway.proxy.TimecoderServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@PreAuthorize("isAuthenticated()")
@RequestMapping("/gateway")
public class EpisodeController {

    @Autowired
    private TimecoderServiceProxy timecoderServiceProxy;

    @GetMapping("/episodes")
    public Object getAllEpisodes(){
        return timecoderServiceProxy.getAllEpisodes();
    }

    @PostMapping(value = "/episodes")
    public Object createEpisode(@RequestBody EpisodePayload episodePayload){
        return timecoderServiceProxy.createEpisode(episodePayload);
    }
}
