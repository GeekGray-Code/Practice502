package cn.yxd.controller;

import cn.yxd.MyException;
import cn.yxd.service.CartService;
import cn.yxd.vo.ResultCode;
import cn.yxd.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 购物车的controller
 */
@Controller
public class CartController {

    @Autowired
    private CartService cartService;

    //添加购物车的请求 entityId 商品的id，quantity商品的数量
    @RequestMapping(value = "/Cart/add")
    @ResponseBody
    public ResultVo add(Integer entityId, Integer quantity) {
        //添加购物车思路
        //1 接受前端传过来的参数
        //2. 调用service，boolean 的方法查询是否是添加购物车成功
        boolean result = false;
        try {
            //添加成功或者是失败的操作
            result = cartService.addCart(entityId, quantity);
            return result ? ResultVo.success():ResultVo.returnFail(ResultCode.ADDCART_ERROR);
        } catch (MyException e) {
            return ResultVo.returnFail(ResultCode.ADDCART_ERROR);
        }
    }
    //修改商品数量：

    ///Cart/refreshCart
    @RequestMapping(value = "/Cart/refreshCart")
    public String refreshCart() {
        return "forward:/commom/pre/searchBar.jsp";
    }

    //结算跳转视图
    @RequestMapping(value = "/Cart/toSettlement")
    public String toSettlement() {
        return "forward:/pre/settlement/toSettlement.jsp";
    }

    //    /Cart/settlement1
    @RequestMapping(value = "/Cart/settlement1")
    public String settlement1(){
        return "forward:/pre/settlement/settlement1.jsp";
    }

    // 结算 形成预备订单/Cart/settlement2
    @RequestMapping(value = "/Cart/settlement2")
    public String settlement2(){
        return "forward:/pre/settlement/settlement2.jsp";
    }

    /**
     * 结算 订单支付提醒
     */
    @RequestMapping(value = "/Cart/settlement3")
    public String settlement3(){
        return "forward:/pre/settlement/settlement3.jsp";
    }


    //修改购物车
    ///Cart/modCart
    @RequestMapping(value = "/Cart/modCart")
    @ResponseBody
    public ResultVo modCart(Integer entityId, Integer quantity) {
        //调用service的方法，判断是否是修改了购物车
        boolean flag = false;
        try {
            flag = cartService.modCart(entityId, quantity);
            //如果是修改了则显示购物车修改成功，            //否则显示购物车修改失败
            return flag?ResultVo.success() : ResultVo.returnFail(ResultCode.CART_MOFIFY_ERROR);
        } catch (MyException e) {
            return ResultVo.returnFail(ResultCode.CART_MOFIFY_ERROR);
        }

    }





}
