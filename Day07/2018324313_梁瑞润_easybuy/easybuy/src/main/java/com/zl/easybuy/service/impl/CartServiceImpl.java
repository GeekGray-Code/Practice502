package com.zl.easybuy.service.impl;

import com.zl.easybuy.exception.EasyBuyException;
import com.zl.easybuy.mapper.ProductMapper;
import com.zl.easybuy.pojo.Product;
import com.zl.easybuy.service.CartService;
import com.zl.easybuy.util.SessionUtils;
import com.zl.easybuy.util.ShopingCart;
import com.zl.easybuy.util.ShopingCartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * 购物车业务类
 *
 * @ClassName: CartServiceImpl
 * @author: suke
 * @since: 2021/9/7 10:21
 */
@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private ProductMapper productMapper;

    @Override
    public boolean addCart(Integer entityId, Integer quantity) throws EasyBuyException {
        /*
          1)  先从session获取购物车
        ​      如果没有:  创建一个购物车,  保存到session,    如果有:  获取购物车中的选项
           2)  判断添加到购物车的数量是否比库存大   如果大:  抛异常: 数量不足的异常    如果小于 进行下一步
           3) 判断购物车中是否包含这个商品
        ​      如果有:   修改购物车的中项的数量    修改之前: 判断 修改之后的数量是否大于库存   如果大:  抛异常: 数量不足的异常
                    如果小于进行   修改操作,修改数量
                如果没有: 新添加一个购物车项
         */
        ShopingCart cart = SessionUtils.getCurrentCart();
        if (cart == null) {
            cart = new ShopingCart();
            SessionUtils.setCartInSession(cart);
        }
        //判断添加到购物车的数量是否比库存大   根据商品id 到数据库查询该商品
        Product product = productMapper.queryById(entityId);
        if (quantity > product.getStock()) {  //数量大于库存
            throw new EasyBuyException("商品数量不足");
        }
        //获取购物车中的所有的购物选项
        List<ShopingCartItem> items = cart.getItems();
        if (!CollectionUtils.isEmpty(items)) { //不是空
            //判断购物车中是否包含这个商品
            for (ShopingCartItem item : items) {
                if (item.getProduct().getId().intValue() == entityId.intValue()) { //存在该商品
                    int count = item.getQuantity() + quantity;  //修改后的数量
                    if (count > product.getStock()) {  //修改后的数量 大于库存
                        throw new EasyBuyException("商品数量不足");
                    } else {
                        item.setQuantity(count); //修改数量
                        return true;
                    }
                }
            }
        }
        //没有该商品
        //创建购物选项
        ShopingCartItem item = new ShopingCartItem();
        item.setProduct(product);
        item.setQuantity(quantity);
        items.add(item);
        return true;
    }


    @Override
    public boolean modifyCart(Integer entityId, Integer quantity) throws EasyBuyException {
        ShopingCart cart = SessionUtils.getCurrentCart();
        if (cart == null) {
            cart = new ShopingCart();
            SessionUtils.setCartInSession(cart);
        }
        //判断添加到购物车的数量是否比库存大   根据商品id 到数据库查询该商品
        Product product = productMapper.queryById(entityId);
        if (quantity > product.getStock()) {  //数量大于库存
            throw new EasyBuyException("商品数量不足");
        }
        //获取购物车中的所有的购物选项
        List<ShopingCartItem> items = cart.getItems();
        if (!CollectionUtils.isEmpty(items)) { //不是空
            //判断购物车中是否包含这个商品
            for (ShopingCartItem item : items) {
                if (item.getProduct().getId().intValue() == entityId.intValue()) { //存在该商品
                    item.setQuantity(quantity); //修改数量
                    return true;
                }
            }
        }
        return false;
    }


}
