package com.feign.feign;

import com.feign.pojo.Result;
import com.feign.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author {曹炳全}
 * @Title UserFeign
 * @Description 调用用户服务
 * @date 2019/12/27 15:45
 */
@FeignClient("user")
public interface UserFeign {
    /**
     * 调用用户登录
     * @param uName
     * @param uPassword
     * @return
     */
    @PostMapping("/user/login")
    Result<User> login(@RequestParam("uName") String uName, @RequestParam("uPassword") String uPassword);
}
