package com.product.service;

import com.product.pojo.Product;
import com.product.pojo.Result;

/**
 * @author {曹炳全}
 * @Title ProductService
 * @Description
 * @date 2019/12/27 16:33
 */
public interface ProductService {
    /**
     * 分页查询
     * @param pageNo
     * @param pageSize
     * @return
     */
    Result findAllByLimit(int pageNo,int pageSize);

    /**
     * 根据编号
     * @param pId
     * @return
     */
    Product findProductBypId(int pId);
}
