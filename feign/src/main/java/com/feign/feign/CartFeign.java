package com.feign.feign;

import com.feign.pojo.Cart;
import com.feign.pojo.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author {曹炳全}
 * @Title CartFeign
 * @Description
 * @date 2019/12/30 15:56
 */
@FeignClient("cart")
public interface CartFeign {
    /**
     * 个人购物车展示
     * @param pageNo
     * @param pageSize
     * @param uId
     * @return
     */
    @GetMapping("/cart/findAll/{pageNo}/{pageSize}/{uId}")
    Result<Cart> findAll(@PathVariable("pageNo") int pageNo, @PathVariable("pageSize") int pageSize, @PathVariable("uId") int uId);

    /**
     * 添加到购物车
     * @param cart
     * @return
     */
    @PostMapping("/cart/add")
    Result<Cart> add(@RequestBody Cart cart);

    /**
     * 删除购物车
     * @param cId
     * @return
     */
    @DeleteMapping("/cart/delete")
    Result<Cart> delete(@RequestParam("cId") int cId);
}
