package com.example.timecoder.gateway.controller;

import com.example.timecoder.gateway.service.SseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@RestController
@RequestMapping("/gateway")
public class SseController {

    @Autowired
    private SseService sseService;

    @RequestMapping(value = "/stream", method = RequestMethod.GET, produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public SseEmitter getNotifications() {
        return sseService.registerEmitter(new SseEmitter());
    }
}
