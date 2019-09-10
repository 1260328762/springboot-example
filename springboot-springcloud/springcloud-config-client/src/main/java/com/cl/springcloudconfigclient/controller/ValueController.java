package com.cl.springcloudconfigclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ValueController {

    @Value("${username}")
    private String username;

    @Value("${email}")
    private String email;

    @Value("${address}")
    private String address;

    @GetMapping("/value")
    @ResponseBody
    public String value() {
        return "username：" + username + " email: " + email + " address: " + address;
    }

}
