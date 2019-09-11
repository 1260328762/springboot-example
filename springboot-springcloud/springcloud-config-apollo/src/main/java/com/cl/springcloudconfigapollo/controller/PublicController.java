package com.cl.springcloudconfigapollo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublicController {

    @Value("${springboot.server.port}")
    private String testPort;


    @GetMapping("/getPort")
    public String getPort() {
        return testPort;
    }

}
