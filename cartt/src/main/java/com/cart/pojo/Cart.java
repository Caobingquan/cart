package com.cart.pojo;

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
public class Cart {
    private int cId;
    private int cuId;
    private int cpId;
    private int cAmount;
    private Product product;
}
