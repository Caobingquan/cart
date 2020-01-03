package com.user.service;

import com.user.pojo.Result;

/**
 * @author {曹炳全}
 * @Title UserService
 * @Description
 * @date 2019/12/27 14:33
 */
public interface UserService {
    /**
     * 用户登录
     * @param uName 用户名
     * @param uPassword 密码
     * @return
     */
    Result login(String uName,String uPassword);
}
