package com.example.demo.controller;


import com.example.demo.bean.ClkUser;
import com.example.demo.beanReq.UserReq;
import com.example.demo.service.UserService;
import com.example.demo.util.RedisUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.xml.crypto.Data;
import java.util.Date;

@RestController
@RequestMapping("/demo")
@Api(tags = "demo api")
public class TestController {

    @Resource
    private UserService userService;

    @Resource
    private RedisUtil redisUtil;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ApiOperation(value="测试")
    @ApiImplicitParam(name="name",value="测试name",required=true)
    public String test(String name) {
        return "hello " + name;
    }

    @RequestMapping(value = "/selectByUserId", method = RequestMethod.GET)
    @ApiOperation(value="通过userid获取用户信息")
    @ApiImplicitParam(name="userId",value="用户id",required=true)
    public ClkUser selectByUserId(Long userId) {
        return userService.selectByUserId(userId);
    }

    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    @ApiOperation(value="保存用户信息")
    public int saveUser(@Valid @RequestBody UserReq userReq) {
        ClkUser user = new ClkUser();
        Date currentDate = new Date();
        user.setCreateTime(currentDate);
        user.setUpdateTime(currentDate);
        BeanUtils.copyProperties(userReq, user);
        return userService.saveUser(user);
    }

    @RequestMapping(value = "/getUserInfo", method = RequestMethod.GET)
    @ApiOperation(value="获取用户信息")
    @ApiImplicitParam(name="userId",value="用户id",required=true)
    public String getUserInfo(String userId) {
        return redisUtil.get(userId).toString();
    }

    @RequestMapping(value = "/setUserInfo", method = RequestMethod.GET)
    @ApiOperation(value="设置用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name="userId",value="用户id",required=true),
            @ApiImplicitParam(name="userName",value="用户姓名",required=true)
    })
    public void setUserInfo(String userId, String userName) {
        redisUtil.set(userId, userName);
    }
}

