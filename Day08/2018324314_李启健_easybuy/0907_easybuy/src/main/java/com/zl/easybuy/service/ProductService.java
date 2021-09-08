package com.zl.easybuy.service;/**
 * @author suke
 * @create 2021-09-06 15:20
 */

import com.zl.easybuy.bo.ProductBO;
import com.zl.easybuy.pojo.Product;
import com.zl.easybuy.util.Pages;

/**
 * TODO
 * @InterfaceName: ProductService
 * @author: suke
 * @since: 2021/9/6 15:20
 */
public interface ProductService {
    /**
     * 分页查询
     * @param productBO
     * @return
     */
    Pages<Product> queryByPage(ProductBO productBO);

    /**
     * 根据商品id查询商品
     * @param id
     * @return
     */
    Product queryById(Integer id);
}
