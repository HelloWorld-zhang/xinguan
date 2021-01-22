package com.xiaoge.system.controller;


import com.xiaoge.system.entity.User;
import com.xiaoge.system.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author xiaoge
 * @since 2021-01-22
 */
@RestController
@RequestMapping("/system/user")
@Api(value = "系统用户模块",tags = "系统用户接口")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    @ApiOperation(value = "用户列表",notes = "查询所有用户信息")
    public List<User> findUsers(){

        List<User> list = userService.list();
        return list;
    }


}
