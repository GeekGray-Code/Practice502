package com.zl.easybuy.vo;

import com.zl.easybuy.pojo.Product;
import com.zl.easybuy.pojo.ProductCategory;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 分类的vo对象
 */
@Data
public class ProductCategoryVo {
    private ProductCategory productCategory;

    private List<ProductCategoryVo> productCategoryVoList = new ArrayList<>();
    private List<Product> productList = new ArrayList<>();

}
