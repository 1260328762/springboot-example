package com.cl.consumerribbon.controller;

import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.Map;

@RestController
public class MessageController {

    @Resource
    private EurekaClient eurekaClient;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("/message/{id}")
    public Map message(@PathVariable Integer id) {
        // InstanceInfo provider = eurekaClient.getNextServerFromEureka("provider", false);
        // String url = provider.getHomePageUrl();

        //使用负载均衡
        ServiceInstance provider = loadBalancerClient.choose("provider");
        return restTemplate.getForObject("http://"+ provider.getInstanceId() +"/message/" + id, Map.class);
    }

    @GetMapping("/test")
    public String test() {
        ServiceInstance provider = loadBalancerClient.choose("provider");
        String s = provider.getInstanceId();
        System.err.println(s);
        return s;
    }
}
