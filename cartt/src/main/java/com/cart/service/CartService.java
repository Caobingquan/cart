package com.cart.service;

import com.cart.pojo.Cart;
import com.cart.pojo.Result;

/**
 * @author {曹炳全}
 * @Title CartService
 * @Description
 * @date 2019/12/27 17:30
 */
public interface CartService {
    /**
     * 填加进购物车
     * @param cart
     * @return
     */
    Result add(Cart cart);

    /**
     * 删除购物车
     * @param cId
     * @return
     */
    Result delete(int cId);

    /**
     * 分页查询
     * @param pageNo
     * @param pageSize
     * @param uId
     * @return
     */
    Result findAllByLimit(int pageNo, int pageSize,int uId);
}
