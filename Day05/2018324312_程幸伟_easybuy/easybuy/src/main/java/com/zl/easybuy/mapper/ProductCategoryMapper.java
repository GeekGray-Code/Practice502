package com.zl.easybuy.mapper;

import com.zl.easybuy.pojo.ProductCategory;

import java.util.List;

/**
 * 商品分类的Mapper
 */
public interface ProductCategoryMapper {
    /**
     * 根据分类的类型查询商品分类
     *
     * @param i 分类类型
     * @return 分类列表
     */
    List<ProductCategory> queryByType(int i);

    /**
     * 根据父分类的id查询子分类集合
     *
     * @param id 父Id
     * @return 分类列表
     */
    List<ProductCategory> queryByParentId(Integer id);
}
