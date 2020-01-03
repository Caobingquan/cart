package com.feign.feign;

import com.feign.pojo.Product;
import com.feign.pojo.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author {曹炳全}
 * @Title ProductFeign
 * @Description
 * @date 2019/12/30 15:56
 */
@FeignClient("product")
public interface ProductFeign {
    /**
     * 商品列表展示
     * @param pageNo
     * @param pageSize
     * @return
     */
    @GetMapping("/product/findAll/{pageNo}/{pageSize}")
    Result<Product> findAll(@PathVariable("pageNo") int pageNo, @PathVariable("pageSize") int pageSize);
    @GetMapping("/product/one/{pId}")
    Product one(@PathVariable int pId);
}
