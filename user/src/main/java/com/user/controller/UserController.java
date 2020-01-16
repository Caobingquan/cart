package com.user.controller;

import com.user.pojo.Result;
import com.user.pojo.User;
import com.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author {曹炳全}
 * @Title UserController
 * @Description
 * @date 2019/12/27 15:38
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/login")
    public Result login(String uName,String uPassword){
        return userService.login(uName,uPassword);
    }

    @PostMapping("/register")
    public Result register(@RequestBody User user){
        return userService.register(user);
    }
}
