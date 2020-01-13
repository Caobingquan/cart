package com.feign.interceptor;


import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.feign.annotation.LoginToken;
import com.feign.annotation.PassToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.lang.reflect.Method;

/**
 * @author {曹炳全}
 * @Title AuthenticationInterceptor
 * @Description
 * @date 2019/12/19 16:48
 */
@Component
public class AuthenticationInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //进入方法之前进行的操作
        System.out.println("拦截器");
        //如果不是映射到方法直接通过
        if(!(handler instanceof HandlerMethod)){
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        if(method.isAnnotationPresent(PassToken.class))
        {
            PassToken passToken = method.getAnnotation(PassToken.class);
            if(passToken.required()){
                return true;
            }
        }
        if(method.isAnnotationPresent(LoginToken.class))
        {
            LoginToken loginToken = method.getAnnotation(LoginToken.class);
            if(loginToken.required()){
                // 从 http 请求头中取出 token
                String token  =  request.getHeader("token");

                JSONObject res = new JSONObject();

                if(token == null){
                    res.put("code",300);
                    res.put("message","无token，请登录");
                    throw new RuntimeException("无token，请登录");
                }
                //验证token是否过期
                JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("secret")).build();
                try{
                    DecodedJWT jwt  =    jwtVerifier.verify(token);
                }catch (JWTVerificationException e){
                    res.put("code",301);
                    res.put("message","token已过期，请重新登录");
                    throw new RuntimeException("token已过期，请重新登录");
                }

                String accountPhone = null;
                String accountType = null;
                try{
                    accountPhone = JWT.decode(token).getClaim("phone").asString();
                    accountType = JWT.decode(token).getClaim("type").asString();
                }
                catch (JWTDecodeException e){
                    res.put("code",300);
                    res.put("message","无效的token，请登录");
                    throw new RuntimeException("无效的token，请登录");
                }
                return true;
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //方法处理之后但是并未渲染视图的时候进行的操作
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //渲染视图之后进行的操作
    }
}
