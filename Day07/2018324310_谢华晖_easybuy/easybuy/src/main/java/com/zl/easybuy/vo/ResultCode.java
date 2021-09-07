package com.zl.easybuy.vo;/**
 * @author suke
 * @create 2021-09-02 8:41
 */

import com.sun.org.apache.regexp.internal.RE;
import lombok.Getter;

/**
 * 响应给前端的枚举类
 *
 * @InterfaceName: ResultCode
 * @author: suke
 * @since: 2021/9/2 8:41
 */
@Getter
public enum ResultCode {
    SUCCESS(2000, "成功响应"),
    LOGIN_FAIL(1001, "登录失败,用户名或密码错误"),
    REGISTER_FAIL(1002,"注册失败"),
    ADD_CART_FAIL(1003,"商品数量不足"),
    FAIL(1004,"操作失败");

    private int code;  //状态码
    private String msg; //消息

    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
