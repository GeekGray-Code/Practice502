package com.zl.easybuy.service;/**
import com.zl.easybuy.pojo.User;

public interface UserService {
    public boolean addUser(User user);

    User queryById(Integer id);


    boolean login(String loginName, String password);
}
