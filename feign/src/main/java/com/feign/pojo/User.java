package com.feign.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

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
    @NotBlank(message = "不能为空")
    public String uName;
    @NotBlank(message = "不能为空")
    @Size(min = 2, max = 15, message = "长度要在2到15之间")
    public String uPassword;
    private int uSex;
    private String uPhoto;
    @Size(min = 11,max = 11,message = "手机号码要为11位")
    public String uPhone;
    private String uAddress;
}
