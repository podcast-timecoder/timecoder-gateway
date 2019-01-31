package com.example.timecoder.gateway.proxy;

import com.example.timecoder.gateway.payload.timecoder.EpisodePayload;
import com.example.timecoder.gateway.payload.timecoder.ThemePayload;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "timecoderService")
public interface TimecoderServiceProxy {

    @RequestMapping("/episodes")
    Object getAllEpisodes();

    @RequestMapping(value = "/episodes", method = RequestMethod.POST)
    Object createEpisode(EpisodePayload episodePayload);

    @RequestMapping(path = "/episodes/{id}", method = RequestMethod.GET)
    Object getEpisodeById(@RequestParam Long id);

    @RequestMapping(value = "/episodes/{id}/start", method = RequestMethod.POST)
    Object startEpisode(@RequestParam Long id);

    @RequestMapping(value = "/episodes/{id}/stop", method = RequestMethod.POST)
    Object stopEpisode(@RequestParam Long id);

    @RequestMapping(value = "/episodes/{id}/theme", method = RequestMethod.POST)
    Object createTheme(@RequestParam Long id, ThemePayload theme);
}
