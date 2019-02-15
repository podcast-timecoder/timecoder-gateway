package com.example.timecoder.gateway.controller;

import com.example.timecoder.gateway.proxy.PatronsServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatronsController {

    @Autowired
    private PatronsServiceProxy patronsServiceProxy;

    @GetMapping("/patrons")
    public Object getAllActivePatrons() {
        return patronsServiceProxy.getAllActivePatrons();
    }
}
