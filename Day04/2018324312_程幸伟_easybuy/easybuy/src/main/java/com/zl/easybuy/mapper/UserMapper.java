package com.zl.easybuy.mapper;

import com.zl.easybuy.pojo.User;

public interface UserMapper {
    /**
     * 根据Id查找数据库的用户
     *
     * @param id uid
     * @return 用户
     */
    User queryById(Integer id);

    /**
     * 添加用户
     *
     * @param user 用户
     * @return 修改的行数
     */
    int addUser(User user);

    /**
     * 根据用户名查询用户
     *
     * @param loginName 登录名
     * @return 用户
     */
    User queryByLoginName(String loginName);
}
