package com.watson.bank.controller;

import com.watson.bank.domain.User;
import com.watson.bank.service.user.UserService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 用户管理类
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("add")
    public Boolean addUser(@RequestBody User user) {
        return userService.save(user);
    }
}
