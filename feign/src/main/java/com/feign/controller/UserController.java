package com.feign.controller;

import com.feign.feign.UserFeign;
import com.feign.pojo.Result;
import com.feign.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * @author {曹炳全}
 * @Title UserController
 * @Description
 * @date 2019/12/27 15:54
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserFeign userFeign;

    @PostMapping("/login")
    public String login(String uName, String uPassword, HttpServletResponse response, Model model, HttpSession session){
        Result<User> result = userFeign.login(uName,uPassword);
        Cookie cookie = new Cookie("token", result.getMsg());
        cookie.setMaxAge(3600);
        cookie.setDomain("localhost");
        cookie.setPath("/");
        response.addCookie(cookie);
        if(200 == result.getCode()){
            System.out.println(result.getData().get(0));
            session.setAttribute("user",result.getData().get(0));
            return "index";
        }
        model.addAttribute("msg",result.getMsg());
        return "login";
    }

}
