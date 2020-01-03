package com.user.service.impl;

import com.user.mapper.UserMapper;
import com.user.pojo.Result;
import com.user.pojo.User;
import com.user.service.UserService;
import com.user.utils.RedisUtils;
import com.user.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author {曹炳全}
 * @Title UserServiceImpl
 * @Description
 * @date 2019/12/27 14:40
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    RedisUtils redisUtils;



    @Override
    public Result login(String uName, String uPassword) {
        User getUser = userMapper.findUserByuName(uName);
        Result result = new Result();
        if (null==getUser){
            result.setCode(201);
            result.setMsg("用户名错误");
        }else {//String.valueOf("count:u"+uName)
            String redisKey = "count:u"+uName;
            if (!redisUtils.hasKey(redisKey) || Integer.valueOf(String.valueOf(redisUtils.get(redisKey))) < 3){
                if (uPassword.equals(getUser.getUPassword())){
                    String token = TokenUtil.getToken("user",getUser.getUName());
                    System.out.println(token);
                    redisUtils.set("user:"+uName,token,60*10);
                    redisUtils.del("count:u"+uName);
                    System.out.println(redisUtils.get("user:"+uName));
                    result.setCode(200);
                    List<User> users = new ArrayList<>();
                    users.add(getUser);
                    result.setData(users);
                    result.setMsg(token);
                }else {
                    redisUtils.incr("count:u"+uName,1);
                    redisUtils.expire("count:u"+uName,60*60*24);
                    result.setCode(202);
                    result.setMsg("密码错误");
                }

            }else {
                result.setCode(203);
                result.setMsg("账号被锁定");
            }
        }
        return result;
    }
}
