package com.user.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author {曹炳全}
 * @Title User
 * @Description
 * @date 2019/12/27 13:38
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int uId;
    private String uName;
    private String uPassword;
    private int uSex;
    private String uPhoto;
    private String uPhone;
    private String uAddress;
}
