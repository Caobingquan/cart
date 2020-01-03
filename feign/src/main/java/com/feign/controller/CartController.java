package com.feign.controller;

import com.feign.annotation.LoginToken;
import com.feign.feign.CartFeign;
import com.feign.pojo.Cart;
import com.feign.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author {曹炳全}
 * @Title CartController
 * @Description
 * @date 2019/12/30 15:58
 */
@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    CartFeign cartFeign;


    @LoginToken
    @GetMapping("/findAll")
    public String findAll(@RequestParam(defaultValue = "1")int pageNo,@RequestParam(defaultValue = "5") int pageSize,@RequestParam(defaultValue = "1") int uId, Model model){
        Result<Cart> result = cartFeign.findAll(pageNo,pageSize,uId);
        model.addAttribute("result",result);
        return "cart";
    }

    @ResponseBody
    @PostMapping("/add")
    public Result add(Cart cart){
        Result<Cart> result = cartFeign.add(cart);
        return result;
    }

    @ResponseBody
    @DeleteMapping("/delete")
    public Result delete(int cId){
        Result<Cart> result = cartFeign.delete(cId);
        return result;
    }
}
