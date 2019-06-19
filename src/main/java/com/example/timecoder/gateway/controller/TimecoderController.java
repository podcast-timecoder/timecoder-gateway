package com.example.timecoder.gateway.controller;

import com.example.timecoder.gateway.payload.timecoder.EpisodePayload;
import com.example.timecoder.gateway.payload.timecoder.ThemePayload;
import com.example.timecoder.gateway.proxy.TimecoderServiceProxy;
import com.example.timecoder.gateway.service.SseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class TimecoderController {

    @Autowired
    private TimecoderServiceProxy timecoderServiceProxy;
    @Autowired
    private SseService sseService;


    @GetMapping("/episodes")
    public Object getAllEpisodes() {
        return timecoderServiceProxy.getAllEpisodes();
    }

    @PostMapping(value = "/episodes")
    public Object createEpisode(@RequestBody EpisodePayload episodePayload) {
        return timecoderServiceProxy.createEpisode(episodePayload);
    }

    @GetMapping("/episodes/{id}")
    public Object getEpisodeDetails(@PathVariable("id") Long id) {
        return timecoderServiceProxy.getEpisodeById(id);
    }

    @PostMapping("/episodes/{id}/start")
    public Object startEpisode(@PathVariable("id") Long id) {
        Object resp = timecoderServiceProxy.startEpisode(id);
        sseService.emitNotification("update");
        return resp;
    }

    @PostMapping("/episodes/{id}/stop")
    public Object stopEpisode(@PathVariable("id") Long id) {
        Object resp = timecoderServiceProxy.stopEpisode(id);
        sseService.emitNotification("update");
        return resp;
    }

    @RequestMapping(value = "/episodes/{id}/theme", method = RequestMethod.POST)
    public Object createTheme(@PathVariable("id") Long id, @Valid @RequestBody ThemePayload theme) {
        Object resp = timecoderServiceProxy.createTheme(id, theme);
        sseService.emitNotification("update");
        return resp;
    }

    @RequestMapping(value = "/episodes/{id}/theme/{themeId}/timestamp", method = RequestMethod.POST)
    public Object setThemeTimestamp(@PathVariable("id") Long id, @PathVariable("themeId") Long themeId) {
        Object resp = timecoderServiceProxy.createTimestamp(id, themeId);
        sseService.emitNotification("update");
        return resp;
    }

    @RequestMapping(value = "/free-theme", method = RequestMethod.POST)
    public Object addFreeTheme(@Valid @RequestBody ThemePayload theme) {
        return timecoderServiceProxy.addFreeTheme(theme);
    }

    @RequestMapping(value = "/theme", method = RequestMethod.GET)
    public Object getAllThemes(@RequestParam("episode") String episode) {
        return timecoderServiceProxy.getAllThemes(episode);
    }

    @RequestMapping(value = "/episodes/{id}", method = RequestMethod.POST)
    public Object linkThemes(@PathVariable("id") Long id, @RequestBody List<Long> themeList) {
        return timecoderServiceProxy.linkThemes(id, themeList);
    }

    @RequestMapping(value = "/episodes/{id}/theme/{themeId}/unlink", method = RequestMethod.POST)
    public Object unlinkThemes(@PathVariable("id") Long id, @PathVariable("themeId") Long themeId) {
        return timecoderServiceProxy.unlinkThemes(id, themeId);
    }

    @RequestMapping(value = "/episodes/{id}/remove", method = RequestMethod.DELETE)
    public Object deleteEpisode(@PathVariable("id") Long id) {
        return timecoderServiceProxy.deleteEpisode(id);
    }

    @RequestMapping(value = "/theme/{id}/delete", method = RequestMethod.DELETE)
    public Object deleteFreeTheme(@PathVariable("id") Long id) {
        return timecoderServiceProxy.deleteTheme(id);
    }

    @RequestMapping(value = "/theme/{id}/update", method = RequestMethod.PUT)
    public Object updateTheme(@PathVariable("id") Long id, @RequestBody ThemePayload themePayload){
        return timecoderServiceProxy.updateTheme(id, themePayload);
    }
}
