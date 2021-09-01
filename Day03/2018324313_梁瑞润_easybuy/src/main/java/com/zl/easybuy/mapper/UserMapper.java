package com.zl.easybuy.mapper;

import com.zl.easybuy.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    public User queryById(Integer id);

    public int addUser(User user);
}
