package com.cl.dubboapi.service;

import org.apache.dubbo.config.annotation.Service;

@Service
public interface UserService {
    String name();
}
