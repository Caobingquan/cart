package com.cart.controller;

import com.cart.pojo.Cart;
import com.cart.pojo.Result;
import com.cart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author {曹炳全}
 * @Title CartController
 * @Description
 * @date 2019/12/27 18:06
 */
@RequestMapping("/cart")
@RestController
public class CartController {
    @Autowired
    CartService cartService;

    @GetMapping("/findAll/{pageNo}/{pageSize}/{uId}")
    public Result findAll(@PathVariable("pageNo") int pageNo, @PathVariable("pageSize") int pageSize,@PathVariable("uId") int uId){
        return cartService.findAllByLimit(pageNo,pageSize,uId);
    }

    @PostMapping("/add")
    public Result add(@RequestBody Cart cart){
        return cartService.add(cart);
    }

    @DeleteMapping("delete")
    public Result delete(int cId){ return cartService.delete(cId); }
}
