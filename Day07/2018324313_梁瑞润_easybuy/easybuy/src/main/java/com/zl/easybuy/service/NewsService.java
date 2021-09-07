package com.zl.easybuy.service;
import com.zl.easybuy.bo.NewsBO;
import com.zl.easybuy.pojo.News;
import com.zl.easybuy.util.Pages;


public interface NewsService {
    Pages<News> queryNewsByPage(NewsBO newsBO);
}
