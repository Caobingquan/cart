package com.feign.hystric;

import com.feign.feign.UserFeign;
import com.feign.pojo.Result;
import com.feign.pojo.User;
import org.springframework.stereotype.Component;

/**
 * @author {曹炳全}
 * @Title UserFeignHystric
 * @Description
 * @date 2020/1/15 15:23
 */
@Component
public class UserFeignHystric implements UserFeign {
    @Override
    public Result<User> login(String uName, String uPassword) {
        Result<User> result = new Result<>();
        result.setCode(203);
        result.setMsg(uName+"，本服务去旅游了");
        return result;
    }

    @Override
    public Result<User> register(User user) {
        Result<User> result = new Result<>();
        result.setCode(203);
        result.setMsg("本服务去旅游了");
        return result;
    }
}
