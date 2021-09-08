package cn.yxd.controller;

import cn.yxd.pojo.Users;
import cn.yxd.service.UserService;
import cn.yxd.util.SessionUtil;
import cn.yxd.vo.ResultCode;
import cn.yxd.vo.ResultVo;
import com.mchange.v2.sql.SqlUtils;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class UserController {
    @Autowired
    private UserService userService;

    //用户进行登录
    //这个默认响应的似逻辑视图，ResponseBody返回值是以数据的形式响应给前端
    @RequestMapping(value = "/User/Login")
    @ResponseBody
    public ResultVo<Null> login(String loginName, String password) {
        System.out.println("登录了");
        ///根据用户的名字和密码，比对数据库的用户名和密码、
        Users users = userService.login(loginName, password);
        if (users == null) {
            //如果不存在，则显示用户名或者是密码错误
            return ResultVo.returnFail(ResultCode.LOGIN_ERROR);
        } else {
            //如果存在这个用户，将用户的信息存入到session中
            SessionUtil sessionUtil = new SessionUtil();
            sessionUtil.setSession("loginUser", users);
            //            //同时响应回正确的状态码。不返回数据
            return ResultVo.success();
        }
    }

    //    /User/page/index
    //如果是操成功了以后则直接转发到首页
    @RequestMapping("/User/page/{path}")
    public String indexView(@PathVariable(value = "path") String path) {
        return "redirect:/pre/" + path + ".jsp";
    }

    //注销登陆的方法
    @RequestMapping("/User/loginOut")
    public String loginOut() {
        SessionUtil.invaildSession();
        return "/pre/index";
    }

    //注册的方法
    ///User/Register  在字段一样且相同的情况下，Users
    @RequestMapping(value = "/User/Register")
    @ResponseBody
    public ResultVo register(Users users) {
        //判断用户是否是否是已经注册
        Users  u = userService.checkUserName(users.getLoginName());
        //在没有注册的情况下，调用service，插入数据
        //在没有注册的情况
        if (u==null) {
            int count = userService.register(users);
            //同时返回注册成功的相关消息
            if (count > 0) {
                //返回注册成功相关信息，但是不发送回数据
                return new ResultVo(ResultCode.SUCCEED, null);
            }
        }
        if (u!=null){
            //这种是已经注册的情况
            //如果注册不成功，就返回到提示注册失败的信息。但是不返回数据
            return new ResultVo(ResultCode.REGISTER_ERROR, null);
        }
        return  new ResultVo(ResultCode.OPERATION_ERROR, null);


    }


}
