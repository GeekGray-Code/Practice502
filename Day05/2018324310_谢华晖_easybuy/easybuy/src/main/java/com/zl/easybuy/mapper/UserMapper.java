package com.zl.easybuy.mapper;

import com.zl.easybuy.pojo.User;

import java.util.List;

public interface UserMapper {
    public User queryById(Integer id);

    public int  addUser(User user);

    /**
     * 根据用户名查询用户
     * @param loginName
     * @return
     */
    User queryByLoginName(String loginName);
}
