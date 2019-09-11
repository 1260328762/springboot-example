package com.shantui.springboothttp.controller;

import com.shantui.springboothttp.util.HttpUtil;
import org.springframework.stereotype.Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Controller
public class IndexController {

    public static void main(String[] args) throws IOException {

        // for (int i = 0; i < 10000; i++) {
        //     new Thread() {
        //         @Override
        //         public void run() {
        //             System.out.println(HttpUtil.sendHttpGet("http://localhost/app/testThread"));
        //         }
        //     }.start();
        // }


        // System.in.read();
        // String username = "adc";
        // System.out.println(HttpUtil.sendHttpGet("https://www.youneed.win/free-ss"));
        // String line = null;
        // String ipAddress = "47.95.15.181";
        // try {
        //
        //     Process pro = Runtime.getRuntime().exec("ping " + ipAddress);
        //     BufferedReader buf = new BufferedReader(new InputStreamReader(
        //             pro.getInputStream()));
        //     while ((line = buf.readLine()) != null)
        //         System.out.println(line);
        // } catch (Exception ex) {
        //     System.out.println(ex.getMessage());
        // }
    }
}
