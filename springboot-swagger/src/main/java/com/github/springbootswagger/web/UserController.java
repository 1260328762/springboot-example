package com.github.springbootswagger.web;

import com.github.springbootswagger.domain.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Api(description = "用户的增删改查")
public class UserController {

    private static List<User> list = new ArrayList<>();

    public UserController(){
        for (int i = 0; i < 10; i++) {
            list.add(new User(i,"username"+i,"hangzhou"));
        }
    }

    @RequestMapping(value = "getUserInfo",method = RequestMethod.GET)
    @ApiOperation(value = "获取单个用户信息")
    public User getUserInfo(){
        User user = new User();
        user.setId(1);
        user.setUsername("chenlinag");
        user.setAddress("hangzhou");

        return user;
    }


    @GetMapping("/findUser/{id}")
    @ApiOperation(value = "根据id查询用户信息")
    public User findUserById(@PathVariable Integer id){
        return id<list.size()? list.get(id):null;
    }



    @PostMapping("/addUser")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "用户ID",required = true,dataType = "Integer"),
            @ApiImplicitParam(name = "username", value = "用户名称", required = true, dataType = "String"),
            @ApiImplicitParam(name = "address", value = "用户地址", required = true, dataType = "String")
    })
    @ApiOperation(value = "增加用户")
    public boolean addUser(User user) {
        return list.add(user);
    }
}
