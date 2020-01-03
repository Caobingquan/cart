package com.feign.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author {曹炳全}
 * @Title PageController
 * @Description
 * @date 2019/12/31 13:31
 */
@Controller
public class PageController {

    @GetMapping("/index")
    public String index(){
        return "index";
    }
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @GetMapping("/register")
    public String register(){
        return "register";
    }
    @GetMapping("/list")
    public String list() {
        return "list";
    }
}
