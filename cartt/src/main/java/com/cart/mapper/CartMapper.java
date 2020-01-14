package com.cart.mapper;

import com.cart.pojo.Cart;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author {曹炳全}
 * @Title CartMapper
 * @Description
 * @date 2019/12/27 17:11
 */
@Repository("cartMapper")
public interface CartMapper {

    /**
     * 根据用户编号和商品编号查询数据是否存在
     * @param cuId
     * @param cpId
     * @return
     */
    Cart findCartByUidAndPid(int cuId,int cpId);

    /**
     * 添加进购物车
     * @param cart
     * @return
     */
    int add(Cart cart);

    /**
     * 更新购物车
     * @param cart
     * @return
     */
    int updateCart(Cart cart);

    /**
     * 删除购物车
     * @param cId
     * @return
     */
    int delete(int cId);


    /**
     * 数数据
     * @param uId
     * @return
     */
    int count(int uId);

    /**
     * 分页查询
     * @param pageNo
     * @param pageSize
     * @param uId
     * @return
     */
    List<Cart> findAll(int pageNo, int pageSize,int uId);
}
