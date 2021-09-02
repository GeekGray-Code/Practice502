package com.zl.easybuy.service.impl;

import com.zl.easybuy.mapper.UserMapper;
import com.zl.easybuy.pojo.User;
import com.zl.easybuy.service.UserService;
import com.zl.easybuy.util.PasswordUtils;
import com.zl.easybuy.util.SessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
   //注入UserMapper对象
    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean addUser(User user) {
 
        //检查用户名是否存在, 如果用户名存在,不能注册
        User user1 = userMapper.queryByLoginName(user.getLoginName());
        if(user1 == null){ //没有这个用户名
            //给密码加密加盐
            user.setPassword(PasswordUtils.generate(user.getPassword()));
            if(userMapper.addUser(user) > 0){
                return true;
            }
        }
        return false;
    }

    @Override
    public User queryById(Integer id) {
        return userMapper.queryById(id);
    }

    @Override
    public boolean login(String loginName, String password) {
       User user =  userMapper.queryByLoginName(loginName);
       if(user != null){
           if(PasswordUtils.verify(password,user.getPassword())){ //true
               //登录成功
               //把用户信息保存到Session域
               SessionUtils.setLoginUserInSession(user);
               return true;
           }
       }
        return false;
    }

}
