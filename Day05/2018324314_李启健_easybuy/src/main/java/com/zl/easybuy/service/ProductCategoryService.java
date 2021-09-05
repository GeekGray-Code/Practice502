package com.zl.easybuy.service;

import com.zl.easybuy.vo.ProductCategoryVo;

import java.util.List;


public interface ProductCategoryService {
    /**
     * 查询所有的分类
     * @return
     */
    List<ProductCategoryVo> queryAllProductCategory();
}
