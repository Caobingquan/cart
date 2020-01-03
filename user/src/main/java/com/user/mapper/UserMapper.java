package com.user.mapper;

import com.user.pojo.User;
import org.springframework.stereotype.Repository;

/**
 * @author {曹炳全}
 * @Title userMapper
 * @Description
 * @date 2019/12/27 13:51
 */
@Repository("userMapper")
public interface UserMapper {
    /**
     * 通过用户查询用户信息
     * @param uName
     * @return
     */
    User findUserByuName(String uName);

    /**
     * 通过用户名更新用户信息
     * @param user
     * @return
     */
    int updateUserByuName(User user);

}
