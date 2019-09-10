package com.github.springbootswagger.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "用户对象")
public class User {

    @ApiModelProperty(value = "用户ID" ,dataType = "Integer" ,required = true)
    private Integer id;
    @ApiModelProperty(value = "用户姓名" ,dataType = "String" ,required = true)
    private String username;
    private String address;
    @ApiModelProperty(value = "用户手机号")
    private String phone;

    public User(){}

    public User(Integer id, String username, String address) {
        this.id = id;
        this.username = username;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
