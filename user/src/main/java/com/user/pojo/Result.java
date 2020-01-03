package com.user.pojo;

import lombok.Data;

import java.util.List;

/**
 * @author {曹炳全}
 * @Title Result
 * @Description 返回类
 * @date 2019/12/27 14:33
 */
@Data
public class Result {
    private int code;
    private String msg;
    private int count;
    private List<User> data;
}
