package com.zl.easybuy.util;

import com.zl.easybuy.pojo.User;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;

 /*HttpSession的工具类*/
 
public class SessionUtils {
    private static final String  USER_IN_SESSION = "loginUser";
    /**
       获取当前用户的Session对象
     
     */
    public static HttpSession getSession(){
        return ((ServletRequestAttributes)(RequestContextHolder.getRequestAttributes())).getRequest().getSession();
    }

    //往Session域存放登录用户信息
    public static void set (Object o) {
        if(o != null){
            getSession().setAttribute(USER_IN_SESSION,o);
        }
    }

    //获取登录信息
    public static User getCurrentUser(){
        return   (User)getSession().getAttribute(USER_IN_SESSION);
    }

    //session失效
    public static void invalidSession(){
        getSession().invalidate();
    }

}
