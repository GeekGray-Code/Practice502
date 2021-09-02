package com.zl.easybuy.service;/**
 * @author suke
 * @create 2021-09-01 15:12
 */

import com.zl.easybuy.pojo.User;


public interface UserService {
    public boolean addUser(User user);

    User queryById(Integer id);

    /**
     * 登录
     * @param loginName
     * @param password
     * @return
     */
    boolean login(String loginName, String password);
}
