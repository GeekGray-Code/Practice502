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
     * @param productBO 封装的商品查询条件类
     * @return 商品类
     */
    List<Product> queryByPages(@Param("productBO") ProductBO productBO);
}
