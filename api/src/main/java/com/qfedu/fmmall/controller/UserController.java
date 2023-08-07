package com.qfedu.fmmall.controller;


import com.qfedu.fmmall.entity.Users;
import com.qfedu.fmmall.service.UserService;
import com.qfedu.fmmall.utils.Base64Utils;
import com.qfedu.fmmall.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
@Api(value = "提供用户登录和注册的接口",tags = "用户管理")
@CrossOrigin
public class UserController {

    @Resource
    private UserService userService;

    @ApiOperation("用户登录接口")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String",name = "username",value = "用户登录账号",required = true),
            @ApiImplicitParam(dataType = "String",name = "password",value = "用户登录密码",required = true)
    })
    @GetMapping("/login")
    public ResultVO login(@RequestParam("username") String name,
                          @RequestParam("password") String pwd){
        ResultVO resultVO =  userService.checkLogin(name,pwd);
        return resultVO;
    }


    @ApiOperation("用户注册接口")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String",name = "username",value = "用户注册账号",required = true),
            @ApiImplicitParam(dataType = "String",name = "password",value = "用户注册密码",required = true)
    })
    @PostMapping("/regist")
    public ResultVO regist(@RequestBody Users user){
        ResultVO resultVO = userService.userResgit(user.getUsername(),user.getPassword());
        return resultVO;
    }


}
