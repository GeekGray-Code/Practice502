package com.zl.easybuy.service.impl;

import com.zl.easybuy.mapper.UserMapper;
import com.zl.easybuy.pojo.User;
import com.zl.easybuy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int addUser(User user) {
        //        int a=1/0;
        return userMapper.addUser(user);
    }

    @Override
    public User queryById(Integer id) {
        return userMapper.queryById(id);
    }
}
