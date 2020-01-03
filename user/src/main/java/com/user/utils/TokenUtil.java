package com.user.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Date;

/**
 * @author {曹炳全}
 * @Title TokenUtil
 * @Description  生成token
 * @date 2019/12/19 16:43
 */
public class TokenUtil {
    /**
     * 生成token 的方法
     * @param type  存的账号类型
     * @param phone 手机号
     * @return
     */
    public static String getToken(String type, String phone){
        Date expireDate = new Date(System.currentTimeMillis()+60*60*1000);//1个小时
        String token = "";
        token = JWT.create()
                .withClaim("phone",phone)//存的信息
                .withClaim("type",type)
                .withExpiresAt(expireDate)//设置签名过期的时间
                .sign(Algorithm.HMAC256("secret"));// 把secret是用来加密数字签名的密钥
        return token;
    }
}
