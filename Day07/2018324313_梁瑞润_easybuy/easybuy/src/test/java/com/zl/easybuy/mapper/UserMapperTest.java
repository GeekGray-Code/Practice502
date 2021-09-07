package com.zl.easybuy.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @author suke
 * @create 2021-09-01 10:44
 */
@RunWith(SpringJUnit4ClassRunner.class)  //创建spring容器, 并且把测试类交给spring容器
@ContextConfiguration("classpath:applicationContext.xml")
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;


    @Test
    public void queryById() {
        System.out.println(userMapper.queryById(2));
    }

    @Test
    public void addUser() {
    }
}