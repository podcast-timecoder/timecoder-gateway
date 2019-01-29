package com.example.polls.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EpisodeController {

    @PostMapping("/episode/create")
    @PreAuthorize("hasRole('USER')")
    public String createEpisode(){
        return "Created!";
    }

}
