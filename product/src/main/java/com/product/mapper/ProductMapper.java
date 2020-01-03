package com.product.mapper;

import com.product.pojo.Product;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author {曹炳全}
 * @Title userMapper
 * @Description
 * @date 2019/12/27 13:51
 */
@Repository("productMapper")
public interface ProductMapper {
    /**
     * 通过用户查询用户信息
     * @param pId
     * @return
     */
    Product findProductBypId(int pId);

    /**
     * 数数据
     * @return
     */
    int count();

    /**
     * 分页查询
     * @param pageNo
     * @param pageSize
     * @return
     */
    List<Product> findAll(int pageNo,int pageSize);

}
