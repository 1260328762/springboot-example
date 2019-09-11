package com.cl.springcloudconsumer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;

@FeignClient(name = "provider",fallback = MessageFeignClientHystrix.class)
public interface MessageFeignClient {

    @GetMapping("/fegin/{id}")
    Map fegin(@PathVariable("id") Integer id);

}
