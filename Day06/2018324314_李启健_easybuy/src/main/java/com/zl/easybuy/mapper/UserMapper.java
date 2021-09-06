package com.zl.easybuy.mapper;

import com.zl.easybuy.pojo.User;

import java.util.List;

//alt + enter  创建该类测试类
public interface UserMapper {
    public User queryById(Integer id);

    public int  addUser(User user);


    User queryByLoginName(String loginName);
}
