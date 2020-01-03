package com.feign.controller;

import com.feign.feign.ProductFeign;
import com.feign.pojo.Product;
import com.feign.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author {曹炳全}
 * @Title ProductController
 * @Description
 * @date 2019/12/30 15:57
 */
@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductFeign productFeign;


    @GetMapping("/findAll")
    public String findAll(@RequestParam(defaultValue = "1")int pageNo,@RequestParam(defaultValue = "10") int pageSize, Model model){
        Result<Product> result = productFeign.findAll(pageNo,pageSize);
        model.addAttribute("result",result);
        return "list";
    }

    @GetMapping("/one")
    public String one(int pId,Model model) {
        Product product = productFeign.one(pId);
        model.addAttribute("product",product);
        return "xiangqing";
    }
}
