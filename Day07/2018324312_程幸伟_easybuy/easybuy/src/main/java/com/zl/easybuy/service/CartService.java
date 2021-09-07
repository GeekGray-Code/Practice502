package com.zl.easybuy.service;

import com.zl.easybuy.exception.EasyBuyException;

public interface CartService {
    /**
     * 添加商品到购物车
     * @param entityId
     * @param quantity
     * @return
     */
    boolean addCart(Integer entityId, Integer quantity) throws EasyBuyException;


    /**
     * 修改购物车数量
     * @param entityId
     * @param quantity
     * @return
     */
    boolean modifyCart(Integer entityId, Integer quantity) throws  EasyBuyException;
}
