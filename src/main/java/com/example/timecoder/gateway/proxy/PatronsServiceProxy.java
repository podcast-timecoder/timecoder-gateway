package com.example.timecoder.gateway.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "patronService", url = "${patronService.ribbon.listOfServers}")
public interface PatronsServiceProxy {

    @RequestMapping("/patrons")
    Object getAllActivePatrons();
}
