package com.cl.springcloudconsumer.feign;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class MessageFeignClientHystrix implements MessageFeignClient {
    @Override
    public Map fegin(Integer id) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", -2);
        map.put("data", "fegin服务熔断启动");
        return map;
    }
}

