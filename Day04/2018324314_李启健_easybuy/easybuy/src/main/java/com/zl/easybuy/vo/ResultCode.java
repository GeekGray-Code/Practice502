package com.zl.easybuy.vo;/**

import com.sun.org.apache.regexp.internal.RE;
import lombok.Getter;

@Getter
public enum ResultCode {
    SUCCESS(2000, "成功响应"),
    LOGIN_FAIL(1001, "登录失败,用户名或密码错误"),
    REGISTER_FAIL(1002,"注册失败");

    private int code;  //状态码
    private String msg; //消息

    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
