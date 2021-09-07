package com.zl.easybuy.util;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 购物车类
 */
@Data
public class ShopingCart {
    private List<ShopingCartItem> items = new ArrayList<>();  
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
