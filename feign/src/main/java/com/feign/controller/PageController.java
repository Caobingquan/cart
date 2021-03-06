package com.feign.controller;

import com.auth0.jwt.JWT;
import com.feign.annotation.LoginToken;
import com.feign.pojo.Cart;
import com.feign.pojo.Result;
import com.feign.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author {曹炳全}
 * @Title PageController
 * @Description
 * @date 2019/12/31 13:31
 */
@Controller
public class PageController {

    @RequestMapping("/index")
    public String index(){
        return "index";
    }
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @GetMapping("/register")
    public String register(Model model){
        User user = new User();
        model.addAttribute("user",user);
        return "register";
    }
    @GetMapping("/list")
    public String list() {
        return "list";
    }
    @LoginToken
    @ResponseBody
    @GetMapping("/cart")
    public String cart(@RequestHeader("token") String token) {
        int uId = JWT.decode(token).getClaim("uId").asInt();
        return ""+uId;
    }
}
