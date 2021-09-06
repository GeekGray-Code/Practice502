package com.zl.easybuy.mapper;

import com.zl.easybuy.bo.ProductBO;
import com.zl.easybuy.pojo.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 商品的mapper
 */
public interface ProductMapper {
    /**
     * 分页查询指定页码的商品信息
     *
     * @param productBO 商品查询类
     * @return 商品列表
     */
    List<Product> queryByPages(@Param("productBO") ProductBO productBO);

    /**
     * 根据查询条件查询记录数
     *
     * @param productBO 商品查询类
     * @return 查询记录数
     */
    Long count(@Param("productBO") ProductBO productBO);

    Product queryById(Integer id);
}
