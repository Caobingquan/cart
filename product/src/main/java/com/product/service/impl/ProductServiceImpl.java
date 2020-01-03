package com.product.service.impl;

import com.product.mapper.ProductMapper;
import com.product.pojo.Product;
import com.product.pojo.Result;
import com.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author {曹炳全}
 * @Title ProductServiceImpl
 * @Description
 * @date 2019/12/27 16:36
 */
@Service("productService")
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductMapper productMapper;

    @Cacheable(value = "products",key = "'a'+#pageNo+#pageSize")
    @Override
    public Result findAllByLimit(int pageNo, int pageSize) {
        Result result = new Result();
        result.setCode(pageNo);
        result.setMsg("");
        int maxPage = 0;
        int count = productMapper.count();
        if(count%pageSize==0){
            maxPage = count/pageSize;
        }else{
            maxPage = count/pageSize+1;
        }
        result.setCount(maxPage);
        result.setData(productMapper.findAll((pageNo-1)*pageSize,pageSize));
        return result;
    }

    @Override
    public Product findProductBypId(int pId) {
        return productMapper.findProductBypId(pId);
    }
}
