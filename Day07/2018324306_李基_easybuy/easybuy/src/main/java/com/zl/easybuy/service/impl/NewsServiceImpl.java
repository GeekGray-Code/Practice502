package com.zl.easybuy.service.impl;

import com.zl.easybuy.bo.NewsBO;
import com.zl.easybuy.mapper.NewsMapper;
import com.zl.easybuy.pojo.News;
import com.zl.easybuy.service.NewsService;
import com.zl.easybuy.util.Pages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewsServiceImpl implements NewsService{
    @Autowired
    private NewsMapper newsMapper;

    @Override
    public Pages<News> queryNewsByPage(NewsBO newsBO) {
        if(newsBO == null){
            return null;
        }
        Pages<News> pages = new Pages<>();
        pages.setPageIndex(newsBO.getPageIndex());
        pages.setPageSize(newsBO.getPageSize());
        pages.setTotalCount(newsMapper.count(newsBO));
        pages.setRecord(newsMapper.queryByPage(newsBO));
        return pages;
    }
}
