package com.example.timecoder.gateway.controller;

import com.example.timecoder.gateway.payload.timecoder.EpisodePayload;
import com.example.timecoder.gateway.payload.timecoder.ThemePayload;
import com.example.timecoder.gateway.proxy.TimecoderServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@PreAuthorize("isAuthenticated()")
@RequestMapping("/gateway")
public class TimecoderController {

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

    @GetMapping("/episodes/{id}")
    public Object getEpisodeDetails(@PathVariable("id") Long id) {
        return timecoderServiceProxy.getEpisodeById(id);
    }

    @PostMapping("/episodes/{id}/start")
    public Object startEpisode(@PathVariable("id") Long id) {
        return timecoderServiceProxy.startEpisode(id);
    }

    @PostMapping("/episodes/{id}/stop")
    public Object stopEpisode(@PathVariable("id") Long id) {
        return timecoderServiceProxy.stopEpisode(id);
    }

    @RequestMapping(value = "/episodes/{id}/theme", method = RequestMethod.POST)
    public Object createTheme(@PathVariable("id") Long id, @Valid @RequestBody ThemePayload theme) {
        return timecoderServiceProxy.createTheme(id, theme);
    }
}
