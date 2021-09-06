package com.zl.easybuy.bo;

import com.zl.easybuy.pojo.Product;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 商品查询条件类
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ProductBO extends BaseBO {
    /**
     * 封装Product对象, 可以使用product类的属性作为查询条件
     */
    private Product product;
}
