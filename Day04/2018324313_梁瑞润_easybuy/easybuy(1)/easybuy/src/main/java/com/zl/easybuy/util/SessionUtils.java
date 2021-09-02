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
 * @ClassName: SessionUtils
 * @author: suke
 * @since: 2021/9/2 10:20
 */
public class SessionUtils {
    private static final String  USER_IN_SESSION = "loginUser";
  
    public static HttpSession getSession(){
        return ((ServletRequestAttributes)(RequestContextHolder.getRequestAttributes())).getRequest().getSession();
    }

    public static void setLoginUserInSession(User loginUser){
        if(loginUser != null){
            getSession().setAttribute(USER_IN_SESSION,loginUser);
        }
    }
    public static User getCurrentUser(){
        return   (Object)getSession().getAttribute(USER_IN_SESSION);
    }
    public static void invalidSession(){
        getSession().invalidate();
    }

}
