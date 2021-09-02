package com.zl.easybuy.service;

import com.zl.easybuy.pojo.User;

/**
 * 用户逻辑接口
 */
public interface UserService {
    /**
     * 添加用户
     *
     * @param user 用户
     * @return 添加结果
     */
    boolean addUser(User user);

    /**
     * 根据Id查找用户
     *
     * @param id uid
     * @return 用户
     */
    User queryById(Integer id);

    /**
     * 登录
     *
     * @param loginName 用户名
     * @param password  密码
     * @return 登录结果
     */
    boolean login(String loginName, String password);
}
