package com.zl.easybuy.mapper;

import com.zl.easybuy.pojo.ProductCategory;

import java.util.List;

/**
 * 分类的Mapper
 * @InterfaceName: ProductCategoryMapper
 * @author: suke
 * @since: 2021/9/3 15:46
 */
public interface ProductCategoryMapper {
    /**
     * 根据分类的类型查询商品分类
     * @param i
     * @return
     */
    List<ProductCategory> queryByType(int i);

    /**
     * 根据父分类的id查询子分类集合
     * @param id
     * @return
     */
    List<ProductCategory> queryByParentId(Integer id);
}
