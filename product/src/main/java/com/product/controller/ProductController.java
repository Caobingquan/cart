package com.product.controller;

import com.product.pojo.Product;
import com.product.pojo.Result;
import com.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author {曹炳全}
 * @Title ProductController
 * @Description
 * @date 2019/12/27 17:58
 */
@RequestMapping("/product")
@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/findAll/{pageNo}/{pageSize}")
    public Result findAll(@PathVariable("pageNo") int pageNo,@PathVariable("pageSize") int pageSize){
        return productService.findAllByLimit(pageNo,pageSize);
    }
    @GetMapping("/one/{pId}")
    public Product one(@PathVariable int pId){
        return productService.findProductBypId(pId);
    }


}
