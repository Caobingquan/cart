package com.cart.service.impl;

import com.cart.mapper.CartMapper;
import com.cart.pojo.Cart;
import com.cart.pojo.Result;
import com.cart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author {曹炳全}
 * @Title CartServiceImpl
 * @Description
 * @date 2019/12/27 17:32
 */
@Service("cartService")
public class CartServiceImpl implements CartService {
    @Autowired
    CartMapper cartMapper;

    @Override
    public Result add(Cart cart) {
        Result result = new Result();
        Cart getCart = cartMapper.findCartByUidAndPid(cart.getCuId(),cart.getCpId());
        if (getCart == null) {
            if (cartMapper.add(cart)>0){
                result.setCode(200);
                result.setMsg("添加成功");
            }else {
                result.setCode(201);
                result.setMsg("添加失败");
            }
        }else {
            cart.setCId(getCart.getCId());
            if (cartMapper.updateCart(cart)>0){
                result.setCode(200);
                result.setMsg("添加成功");
            }else {
                result.setCode(201);
                result.setMsg("添加失败");
            }
        }

        return result;
    }

    @Override
    public Result delete(int cId) {
        Result result = new Result();
        if (cartMapper.delete(cId) > 0) {
            result.setCode(200);
            result.setMsg("删除成功");
            return result;
        }
        result.setCode(201);
        result.setMsg("删除失败");
        return result;
    }

//    @Cacheable(value = "carts",key = "#uId+':'+#pageNo+':'+#pageSize")
    @Override
    public Result findAllByLimit(int pageNo, int pageSize, int uId) {
        Result result = new Result();
        result.setCode(200);
        result.setMsg("");
        result.setCount(cartMapper.count(uId));
        List<Cart> carts = cartMapper.findAll((pageNo-1)*pageSize,pageSize,uId);
        result.setData(carts);
        return result;
    }
}
