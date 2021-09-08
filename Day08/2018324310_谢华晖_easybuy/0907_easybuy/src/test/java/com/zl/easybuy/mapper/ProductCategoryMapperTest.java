package com.zl.easybuy.mapper;

import com.zl.easybuy.service.ProductCategoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @author suke
 * @create 2021-09-03 16:16
 */
@RunWith(SpringJUnit4ClassRunner.class)  //创建spring容器, 并且把测试类交给spring容器
@ContextConfiguration("classpath:applicationContext.xml")
public class ProductCategoryMapperTest {
  @Autowired
  private ProductCategoryMapper productCategoryMapper;
    @Test
    public void queryByType() {
        productCategoryMapper.queryByType(1);
    }

    @Test
    public void queryByParentId() {
        productCategoryMapper.queryByParentId(548);
    }
}