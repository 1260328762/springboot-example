package com.cl.dubboapi;

import com.cl.dubboapi.service.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DubboConsumerApplicationTests {

    @Reference
    private UserService userService;

    @Test
    public void contextLoads() {
        System.out.println(userService.name());
    }

}
