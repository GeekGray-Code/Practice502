package com.zl.easybuy.web;

import com.zl.easybuy.exception.EasyBuyException;
import com.zl.easybuy.service.CartService;
import com.zl.easybuy.vo.ResultCode;
import com.zl.easybuy.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 购物车的Controller
 */
@Controller
@RequestMapping("/Cart")
public class CartController {
    @Autowired
    private CartService cartService;


    /**
     * 往购物车添加商品
     * @param entityId
     * @param quantity
     * @return
     */
    @PostMapping("/add")
    @ResponseBody
    public ResultVO add(Integer entityId,Integer quantity){
        try{
            boolean result =  cartService.addCart(entityId,quantity);
            return result?ResultVO.success():ResultVO.returnFail(ResultCode.FAIL);
        }catch(EasyBuyException e){  // 数量不足
            return ResultVO.returnFail(ResultCode.ADD_CART_FAIL);
        }
    }

    @RequestMapping("/refreshCart")
    public String refreshCart(){
        return "forward:/common/pre/searchBar.jsp";
    }


    //跳转到结算页面
    @RequestMapping("/toSettlement")
    public String toSettlement(){
        return "forward:/pre/settlement/toSettlement.jsp";
    }

    //结算1
    @RequestMapping("/settlement1")
    public String settlement1(){
        return "forward:/pre/settlement/settlement1.jsp";
    }


    /**
     * 修改数量
     * @param entityId
     * @param quantity
     * @return
     */
    @PostMapping("/modifyCart")
    @ResponseBody
    public ResultVO modifyCart(Integer entityId,Integer quantity){
        try{
            boolean result =  cartService.modifyCart(entityId,quantity);
            return result?ResultVO.success():ResultVO.returnFail(ResultCode.FAIL);
        }catch(EasyBuyException e){  // 数量不足
            return ResultVO.returnFail(ResultCode.ADD_CART_FAIL);
        }
    }
}
