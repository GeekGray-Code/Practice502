package com.zl.easybuy.util;

import com.zl.easybuy.pojo.Product;
import lombok.Data;

/**
 *购物车项
 * @ClassName: ShopingCartItem
 * @author: suke
 * @since: 2021/9/7 9:18
 */
@Data
public class ShopingCartItem {
    private Product product;  //商品信息
    private Integer quantity;   //数量
    //private Double cost;//小计


    public double getCost(){
       if(product == null || quantity == null){
            return 0;
       }
       return product.getPrice() * quantity;
    }
}
