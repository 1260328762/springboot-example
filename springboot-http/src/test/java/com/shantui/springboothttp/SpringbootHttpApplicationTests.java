package com.shantui.springboothttp;

import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonBooleanFormatVisitor;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonObjectFormatVisitor;
import com.shantui.springboothttp.util.HttpUtil;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootHttpApplicationTests {

    @Test
    public void contextLoads() {
    }


    @Test
    public void testHttpGet() {
        String s = HttpUtil.sendHttpGet("https://www.baidu.com/");
        System.out.println(s);
    }


    @Test
    public void testHttpPost() {
        System.out.println(HttpUtil.sendHttpPost("http://localhost:8080/loan-rms/system/getMenuList", null));
    }


}
