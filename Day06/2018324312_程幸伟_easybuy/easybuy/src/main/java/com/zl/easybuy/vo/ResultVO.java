package com.zl.easybuy.vo;

import lombok.Getter;

import java.util.List;

/**
 * 响应给前台的统一对象
 */
@Getter
public class ResultVO<T> {
    private final int code;  //状态码
    private final String msg; //消息
    private final List<T> datas;

    public ResultVO(ResultCode resultCode, List<T> datas) {
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
        this.datas = datas;
    }

    public ResultVO(List<T> datas) {
        this(ResultCode.SUCCESS, datas);
    }

    /**
     * 正常响应,不响应数据
     */
    public static ResultVO success() {
        return new ResultVO<>(null);
    }

    /**
     * 失败的响应
     */
    public static ResultVO returnFail(ResultCode resultCode) {
        return new ResultVO<>(resultCode, null);
    }
}
