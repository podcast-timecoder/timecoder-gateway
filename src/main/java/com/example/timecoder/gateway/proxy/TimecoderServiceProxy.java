package com.example.timecoder.gateway.proxy;

import com.example.timecoder.gateway.payload.timecoder.EpisodePayload;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "timecoderService")
public interface TimecoderServiceProxy {

    @RequestMapping("/episodes")
    Object getAllEpisodes();

    @RequestMapping(value = "/episodes", method = RequestMethod.POST)
    Object createEpisode(EpisodePayload episodePayload);
}
