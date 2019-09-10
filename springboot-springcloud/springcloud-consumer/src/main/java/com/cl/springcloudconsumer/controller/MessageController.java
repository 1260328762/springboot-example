package com.cl.springcloudconsumer.controller;

import com.cl.springcloudconsumer.feign.MessageFeignClient;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
public class MessageController {

    @Resource
    private EurekaClient eurekaClient;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private MessageFeignClient feignClient;



    @GetMapping("/message/{id}")
    public Map message(@PathVariable Integer id) {
        InstanceInfo provider = eurekaClient.getNextServerFromEureka("provider", false);
        String url = provider.getHomePageUrl();
        return restTemplate.getForObject(url + "message/" + id, Map.class);
    }


    //使用feign客户端进行请求服务端接口
    @GetMapping("/fegin/{id}")
    public Map fegin(@PathVariable Integer id) {
        return feignClient.fegin(id);
    }



    //测试服务熔断效果
    @GetMapping("testBreaker")
    @HystrixCommand(fallbackMethod = "fail")
    public Map testBreaker(){
        return feignClient.fegin(100);
    }

    public Map fail() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("id", -1);
        hashMap.put("data", "提供者调用失败");
        return hashMap;
    }


}
