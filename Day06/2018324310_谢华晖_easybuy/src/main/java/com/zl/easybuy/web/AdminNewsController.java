package com.zl.easybuy.web;

import com.zl.easybuy.bo.NewsBO;
import com.zl.easybuy.pojo.News;
import com.zl.easybuy.service.NewsService;
import com.zl.easybuy.util.Pages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 后台新闻的controller
 * 
 */
@Controller
@RequestMapping("/admin/news")
public class AdminNewsController {
    @Autowired
    private NewsService newsService;


    @RequestMapping("/queryNewsList")
    public String queryNewsList(@RequestParam(defaultValue = "1" ) Integer pageIndex, Model model){
        NewsBO newsBO = new NewsBO();
        newsBO.setPage(true);
        newsBO.setPageIndex(pageIndex);
        newsBO.setPageSize(5);
        Pages<News> newsPages = newsService.queryNewsByPage(newsBO);
        newsPages.setUrl("admin/news/queryNewsList?time="+System.currentTimeMillis());
        model.addAttribute("pager",newsPages);

        return "forward:/backend/news/newsList.jsp";

    }
}
