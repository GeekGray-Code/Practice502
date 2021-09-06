package com.zl.easybuy.service;

import com.zl.easybuy.bo.ProductBO;
import com.zl.easybuy.pojo.Product;
import com.zl.easybuy.util.Pages;

/**
 * 商品业务层
 */
public interface ProductService {
    /**
     * 分页查询
     *
     * @param productBO 商品查询类
     * @return 商品分页列表
     */
    Pages<Product> queryByPage(ProductBO productBO);

    /**
     * 根据商品id查询商品
     *
     * @param id 商品id
     * @return 商品
     */
    Product queryById(Integer id);
}
