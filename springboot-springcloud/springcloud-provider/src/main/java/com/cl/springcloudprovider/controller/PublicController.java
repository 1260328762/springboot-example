package com.cl.springcloudprovider.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class PublicController {


    @GetMapping("/message/{id}")
    public Map message(@PathVariable Integer id){
        Map<String,Object> map = new HashMap<>();
        map.put("id", id);
        map.put("data", "杭州城建国北路地面塌陷");
        map.put("date", new Date());
        return map;
    }

    @GetMapping("/fegin/{id}")
    public Map fegin(@PathVariable Integer id) {
        Map<String,Object> map = new HashMap<>();
        map.put("id", id);
        map.put("data", "fegin请求测试");
        return map;
    }

}
