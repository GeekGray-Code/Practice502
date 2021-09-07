package com.zl.easybuy.util;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 购物车类
 *
 * @ClassName: ShopingCart
 * @author: suke
 * @since: 2021/9/7 9:17
 * <p>
 * 格式化代码:
 * ctrl+alt+L
 */
@Data
public class ShopingCart {
    private List<ShopingCartItem> items = new ArrayList<>();  //项集合
    //private Double sum;

    //计算购物车的总计
    public Double getSum(){
        double sum = 0;
        for(ShopingCartItem item: items){
            sum += item.getCost();
        }
        return sum;
    }
}
