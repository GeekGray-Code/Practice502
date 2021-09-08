package com.zl.easybuy.bo;

import com.zl.easybuy.pojo.Product;
import lombok.Data;

/**
 * 商品查询条件类
 * @ClassName: ProductBO
 * @author: suke
 * @since: 2021/9/3 15:21
 */
@Data
public class ProductBO extends BaseBO {
   private Product product;  //包装了Product对象,  可以使用product类的属性作为查询条件

}
