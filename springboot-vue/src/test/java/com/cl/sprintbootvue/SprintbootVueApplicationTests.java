package com.cl.sprintbootvue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SprintbootVueApplicationTests {

    @Test
    public void contextLoads() {

    }

    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir" + File.separator + "/"));
    }
}
