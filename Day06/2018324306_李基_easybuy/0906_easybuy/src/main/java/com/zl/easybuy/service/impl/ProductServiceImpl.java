package com.zl.easybuy.service.impl;

import com.zl.easybuy.bo.ProductBO;
import com.zl.easybuy.mapper.ProductMapper;
import com.zl.easybuy.pojo.Product;
import com.zl.easybuy.service.ProductService;
import com.zl.easybuy.util.Pages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;


    @Override
    public Pages<Product> queryByPage(ProductBO productBO) {
        if(productBO == null){
            return null;
        }
        Pages<Product>  pages = new Pages<>();
        pages.setPageIndex(productBO.getPageIndex());
        pages.setPageSize(productBO.getPageSize());
        pages.setTotalCount(productMapper.count(productBO));
        pages.setRecord(productMapper.queryByPages(productBO));
        return pages;
    }

    @Override
    public Product queryById(Integer id) {
        if(id == null){
            return null;
        }
        return productMapper.queryById(id);
    }
}
