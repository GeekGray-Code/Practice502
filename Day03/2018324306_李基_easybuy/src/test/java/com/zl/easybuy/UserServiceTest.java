package com.zl.easybuy;


import com.zl.easybuy.pojo.User;
import com.zl.easybuy.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testUserService(){
        User user=new User();
        user.setLoginName("s").setEmail("1454548529@qq.com").setUserName("某").setIdentityCode("12345678").setMobile("12345678").setPassword("123").setSex(1).setType(0);
        System.out.println(userService.addUser(user));
    }
}