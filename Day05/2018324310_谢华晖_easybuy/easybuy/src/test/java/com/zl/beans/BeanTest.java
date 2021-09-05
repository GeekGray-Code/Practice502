package com.zl.beans;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.util.HashSet;

/**
 * bean测试类
 * @ClassName: BeanTest
 * @author: suke
 * @since: 2021/8/31 16:22
 */
@RunWith(SpringJUnit4ClassRunner.class)  //创建spring容器, 并且把测试类交给spring容器
@ContextConfiguration("classpath:applicationContext.xml")
public class BeanTest {
    @Autowired  //sprung容器中DataSource的对象注入进来
    private DataSource dataSource;
    private SqlSessionFactoryBean  sqlSessionFactoryBean;

    @Test
    public void test1(){  //测试方法要求:  返回值void  无参
        System.out.println(dataSource);
    }

    @Test
    public void test2(){
        System.out.println(sqlSessionFactoryBean);
    }

    @Test
    public void test3(){
        HashSet<Integer> hashSet = new HashSet<>();
    }

}
