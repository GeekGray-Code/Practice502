package com.zl.easybuy.service;

import com.zl.easybuy.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @author suke
 * @create 2021-09-01 15:34
 */
@RunWith(SpringJUnit4ClassRunner.class)  //创建spring容器, 并且把测试类交给spring容器
@ContextConfiguration("classpath:applicationContext.xml")
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void addUser() {
        User user = new User();
        user.setLoginName("zhaoliu");
        user.setPassword("123");
        user.setUserName("赵六");
        user.setEmail("zhaoliu@163.com");
        user.setType(0);
        user.setIdentityCode("1123213123123123123");
        user.setMobile("16521566532");
        user.setSex(1);

        userService.addUser(user);
    }
}