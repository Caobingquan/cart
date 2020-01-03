package com.feign.pojo;

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
public class Product {
    private int pId;
    private String pName;
    private int pPrice;
    private int pInventory;
    private String pPicture;
    private int pStatus;
    private String pDetails;
}
