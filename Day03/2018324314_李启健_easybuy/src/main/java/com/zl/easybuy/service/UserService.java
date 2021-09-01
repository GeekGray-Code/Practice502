package com.zl.easybuy.service;

import com.zl.easybuy.pojo.User;

public interface UserService {
    public int addUser(User user);


    User queryById(Integer id);
}
