package com.zl.easybuy.mapper;

import com.zl.easybuy.bo.ProductBO;
import com.zl.easybuy.pojo.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface ProductMapper {

    List<Product> queryByPages(@Param("productBO") ProductBO productBO);


    Long count(@Param("productBO") ProductBO productBO);

    Product queryById(Integer id);
}
