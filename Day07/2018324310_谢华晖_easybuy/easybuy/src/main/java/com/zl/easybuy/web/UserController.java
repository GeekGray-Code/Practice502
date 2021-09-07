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

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/User")
public class UserController {
    @Autowired
    private UserService userService;

    //@RequestMapping(value="/queryById",method = RequestMethod.GET) //给方法绑定一个url, 被用户来请求
    // @GetMapping("/queryById")
    @RequestMapping("/queryById")
    public String queryById(Integer id, Model model) {
        User user = userService.queryById(id);
        model.addAttribute("user", user);
        return "forward:/index.jsp"; //转发到index.jsp

    }

    /**
     * 登录的接口
     * @param loginName  用户名
     * @param password   密码
     * @return
     */
    @PostMapping("/Login")
    // 默认响应的是一个逻辑视图名:   com.zl.easybuy.vo.ResultVo
    @ResponseBody  //表示这个方法的返回值 以数据形式响应给前端  如果添加的json相关的依赖, 把java对象转换为json字符串., 响应
    public ResultVO<Null> login(String loginName,String password){
        //查询easybuy_user
        //查询到有数据, 说明登录成功  把用户信息保存到Session域,  响应一个正常的
        // 没有数据, 说明登录失败, 响应一个登录实现的ResultVO

        /*
       boolean isOk =  userService.login(loginName,password);
       if(isOk){  //登录成功
            return  ResultVO.success();
       }
       return ResultVO.returnFail(ResultCode.LOGIN_FAIL);
       */
       return  userService.login(loginName,password)? ResultVO.success():ResultVO.returnFail(ResultCode.LOGIN_FAIL);
    }


    ///page/index
    //RestFul风格
    @RequestMapping("/page/{pageName}")
    public String  jumpPage(@PathVariable("pageName") String page){
        return "redirect:/pre/"+page+".jsp";    //重定向到某个页面

    }


    /**
     * 注销
     * @return
     */
    @RequestMapping("/loginOut")
    public String  loginout(){
        //1.让session失效
        SessionUtils.invalidSession();
        //重定向到login.jsp
        return "redirect:/pre/login.jsp";

    }


    //注册
    @PostMapping("/Register")
    @ResponseBody
    public ResultVO<Null> register(User user){
        //设置用户类型:   魔鬼数字
        user.setType(Constant.USER_TYPE_NOMAL);
        return userService.addUser(user)?ResultVO.success():ResultVO.returnFail(ResultCode.REGISTER_FAIL);
    }


}
