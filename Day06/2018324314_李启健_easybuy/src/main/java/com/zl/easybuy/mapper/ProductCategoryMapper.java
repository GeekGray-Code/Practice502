package com.zl.easybuy.mapper;

import com.zl.easybuy.pojo.ProductCategory;

import java.util.List;

/**

 */
public interface ProductCategoryMapper {

    List<ProductCategory> queryByType(int i);

    /**
     * 根据父分类的id查询子分类集合
     * @param id
     * @return
     */
    List<ProductCategory> queryByParentId(Integer id);
}
