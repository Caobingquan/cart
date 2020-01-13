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

import javax.imageio.ImageIO;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
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

    /**
     * 手机图片验证码
     */
    @RequestMapping("/checkcode")
    @ResponseBody
    public String checkcode(HttpServletRequest request, String checkcode){
        System.out.println("yhdd");
        String sessionCode = (String) request.getSession().getAttribute("imgCode");
        if (null == sessionCode || "".equals(sessionCode) || null == checkcode || "".equals(checkcode)) {
            return "{\"msg\":\"m1\"}";
        } else if (checkcode.equalsIgnoreCase(sessionCode)){
            return "{\"msg\":\"m3\"}";
        } else {
            return "{\"msg\":\"m2\"}";
        }
    }

    /**
     图片验证码
     */
    @RequestMapping("/createImage")
    public void code(HttpServletRequest request, HttpServletResponse response){
        //1.规定验证码范围
        System.out.println("createImage");
        char[] chars="qwertyuiopasdfghjklzxcvbnm148523690".toCharArray();
        //2.获取一个Image 对象 用于存放图片
        BufferedImage image =new BufferedImage(80,20,BufferedImage.TYPE_3BYTE_BGR);
        //3.获取画笔能够将写入图片中
        Graphics graphics=image.getGraphics();
        //4.图片背景设置
        graphics.setColor(Color.LIGHT_GRAY);
        graphics.fillRect(0,0,80,20);
        //5.边框设置
        graphics.setColor(Color.BLACK);
        graphics.drawRect(0,0,79,19);
        //6.字体设置
        graphics.setColor(Color.RED);
        graphics.setFont(new Font("黑体",Font.BOLD,18));
        //7.随机生成4个字符，作为验证码
        Random random=new Random();
        StringBuilder stringBuilder=new StringBuilder();
        for (int i=0;i<4;i++){
            //随机位置根据自己定义的chars数组而定
            int n=random.nextInt(chars.length);
            //将chars数组中对应位置内容 放入到sb 对象
            stringBuilder.append(chars[n]+" ");
        }
        //8.随机数添加到画布中
        graphics.drawString(stringBuilder.toString(),3,15);
        //9.添加干扰点
        graphics.setColor(Color.BLUE);
        for (int i=0;i<100;i++){
            int x= random.nextInt(80);
            int y= random.nextInt(20);
            graphics.drawOval(x,y,1,1);
        }
        //10.显示拼装图片
        HttpSession session=request.getSession();
        try {
            ImageIO.write(image,"jpeg",response.getOutputStream());
        } catch (IOException e){
            e.printStackTrace();
        }

        String[] strings=stringBuilder.toString().split(" ");
        String code="";
        for (int i=0;i<strings.length;i++){
            code+=strings[i];
        }
        session.setAttribute("imgCode",code);

    }

}
