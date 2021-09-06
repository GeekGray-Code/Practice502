package com.zl.easybuy.util;/**
 * @author suke
 * @create 2021-09-02 10:20
 */

import com.zl.easybuy.pojo.User;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;

/**
 * HttpSession的工具类
 * 
 */
public class SessionUtils {
    private static final String  USER_IN_SESSION = "loginUser";
    /**
     * 得到当前用户的Session对象
     * @return
     */
    public static HttpSession getSession(){
        return ((ServletRequestAttributes)(RequestContextHolder.getRequestAttributes())).getRequest().getSession();
    }

    //往Session域存放登录用户信息
    public static void setLoginUserInSession(User loginUser){
        if(loginUser != null){
            getSession().setAttribute(USER_IN_SESSION,loginUser);
        }
    }

    //从session域获取登录的用户信息
    public static User getCurrentUser(){
        return   (User)getSession().getAttribute(USER_IN_SESSION);
    }

    //让session失效
    public static void invalidSession(){
        getSession().invalidate();
    }

}
