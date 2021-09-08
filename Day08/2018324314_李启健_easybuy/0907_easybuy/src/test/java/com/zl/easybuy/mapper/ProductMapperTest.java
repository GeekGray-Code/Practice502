package com.zl.easybuy.mapper;

import com.zl.easybuy.bo.ProductBO;
import com.zl.easybuy.pojo.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @author suke
 * @create 2021-09-03 16:07
 */
@RunWith(SpringJUnit4ClassRunner.class)  //创建spring容器, 并且把测试类交给spring容器
@ContextConfiguration("classpath:applicationContext.xml")
public class ProductMapperTest {
    @Autowired
    private ProductMapper productMapper;
    @Test
    public void queryByPages() {
        ProductBO productBO = new ProductBO();
        productBO.setPage(true);
        productBO.setStartIndex(0);
        productBO.setPageSize(6);

        Product product = new Product();
        productBO.setProduct(product);
        product.setCategoryLevel1Id(548);
        product.setName("香");
        productMapper.queryByPages(productBO);
    }
}