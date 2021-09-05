package com.zl.easybuy.vo;

import com.zl.easybuy.pojo.Product;
import com.zl.easybuy.pojo.ProductCategory;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
public class ProductCategoryVo {
    private ProductCategory productCategory;
    //如果集合属性, 推荐new 出集合对象
    private List<ProductCategoryVo> productCategoryVoList = new ArrayList<>();
    private List<Product> productList = new ArrayList<>();

}
