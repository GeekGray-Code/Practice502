package com.zl.easybuy.mapper;

import com.zl.easybuy.bo.ProductBO;
import com.zl.easybuy.pojo.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 商品的mapper
 * @InterfaceName: ProductMapper
 * @author: suke
 * @since: 2021/9/3 15:47
 */
public interface ProductMapper {
    /**
     * 分页查询指定页码的商品信息
     * @param productBO
     * @return
     */
    List<Product> queryByPages(@Param("productBO") ProductBO productBO);
}
