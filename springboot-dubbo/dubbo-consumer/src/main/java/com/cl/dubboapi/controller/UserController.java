package com.cl.dubboapi.controller;

import com.cl.dubboapi.service.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Reference
    private UserService userService;


    @RequestMapping("/name")
    public String name() {
        return userService.name();
    }

}
