package com.zl.easybuy.vo;

import lombok.Getter;

/**
 * 响应给前端的枚举类
 */
@Getter
public enum ResultCode {
    SUCCESS(2000, "成功响应"),
    LOGIN_FAIL(1001, "登录失败,用户名或密码错误"),
    REGISTER_FAIL(1002, "注册失败");

    private final int code;  //状态码
    private final String msg; //消息

    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
