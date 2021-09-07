package com.zl.easybuy.service;

import com.zl.easybuy.vo.ProductCategoryVo;

import java.util.List;

/**
 * 商品分类的业务层
 * @InterfaceName: ProductCategoryService
 * @author: suke
 * @since: 2021/9/3 14:46
 */
public interface ProductCategoryService {
    /**
     * 查询所有的分类
     * @return
     */
    List<ProductCategoryVo> queryAllProductCategory();
}
