package com.zl.easybuy.web;

import com.zl.easybuy.pojo.User;
import com.zl.easybuy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/queryById")
    public String queryById(Integer id, Model model){
        User user=userService.queryById(id);
        System.out.println(user.getLoginName());
        model.addAttribute("user",user);
        return "forward:/index.jsp";
    }
}
