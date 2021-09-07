package com.zl.easybuy.exception;
/**
 * 自定义异常类
 * 
 */
public class EasyBuyException  extends Exception{
    public EasyBuyException() {
    }

    public EasyBuyException(String message) {
        super(message);
    }

    public EasyBuyException(String message, Throwable cause) {
        super(message, cause);
    }

    public EasyBuyException(Throwable cause) {
        super(cause);
    }

    public EasyBuyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
