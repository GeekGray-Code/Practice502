package com.zl.easybuy.web;

import com.zl.easybuy.pojo.User;
import com.zl.easybuy.service.UserService;
import com.zl.easybuy.util.Constant;
import com.zl.easybuy.util.SessionUtils;
import com.zl.easybuy.vo.ResultCode;
import com.zl.easybuy.vo.ResultVO;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/User")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/queryById")
    public String queryById(Integer id, Model model) {
        User user = userService.queryById(id);
        model.addAttribute("user", user);
        return "forward:/index.jsp"; //转发到index.jsp
    }

    /**
     * 登录的接口
     *
     * @param loginName 用户名
     * @param password  密码
     */
    @PostMapping("/Login")
    @ResponseBody
    public ResultVO<Null> login(String loginName, String password) {
        return userService.login(loginName, password) ? ResultVO.success() : ResultVO.returnFail(ResultCode.LOGIN_FAIL);
    }

    @RequestMapping("/page/{pageName}")
    public String jumpPage(@PathVariable("pageName") String page) {
        return String.format("redirect:/pre/%s.jsp", page);
    }

    /**
     * 注销
     */
    @RequestMapping("/loginOut")
    public String loginout() {
        //1.让session失效
        SessionUtils.invalidSession();
        //重定向到login.jsp
        return "redirect:/pre/login.jsp";

    }

    /**
     * 注册
     *
     * @param user 前端传过来的用户
     */
    @PostMapping("/Register")
    @ResponseBody
    public ResultVO<Null> register(User user) {
        //设置用户类型
        user.setType(Constant.USER_TYPE_NORMAL);
        return userService.addUser(user) ? ResultVO.success() : ResultVO.returnFail(ResultCode.REGISTER_FAIL);
    }
}
