package com.zl.easybuy.service;

import com.zl.easybuy.vo.ProductCategoryVo;

import java.util.List;

/**
 * 商品分类的业务层
 */
public interface ProductCategoryService {
    /**
     * 查询所有的分类
     */
    List<ProductCategoryVo> queryAllProductCategory();
}
