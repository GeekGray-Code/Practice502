package com.zl.easybuy.vo;

import lombok.Data;
import lombok.Getter;

import java.util.List;

/**
 * 响应给前台的对象
 * @ClassName: ResultVO
 * @author: suke
 * @since: 2021/9/2 8:29
 */
@Getter
public class ResultVO<T> {
    private int code;  //状态码
    private String msg; //消息
    private List<T> datas;

    public ResultVO(ResultCode resultCode,List<T> datas){
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
        this.datas = datas;
    }

    //正常的响应
    public ResultVO(List<T> datas){
        this(ResultCode.SUCCESS,datas);
    }

    /**
     * 正常响应,  不响应数据
     * @return
     */
   public static ResultVO success(){
        return new ResultVO(null);
   };

    /**
     * 失败的响应
     */
    public static ResultVO returnFail(ResultCode resultCode){
           return  new  ResultVO(resultCode,null);
    }
}
