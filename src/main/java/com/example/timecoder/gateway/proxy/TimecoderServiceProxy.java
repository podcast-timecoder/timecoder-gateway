package com.example.timecoder.gateway.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "timecoderService")
public interface TimecoderServiceProxy {

    @RequestMapping("/episodes")
    Object getAllEpisodes();
}
