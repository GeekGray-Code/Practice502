package com.zl.easybuy.web;

import com.zl.easybuy.bo.NewsBO;
import com.zl.easybuy.pojo.News;
import com.zl.easybuy.service.NewsService;
import com.zl.easybuy.service.ProductCategoryService;
import com.zl.easybuy.util.Pages;
import com.zl.easybuy.vo.ProductCategoryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 首页的处理器
 */
@Controller
@RequestMapping("/Home")
public class HomeController {
    @Autowired
    private ProductCategoryService productCategoryService;
    @Autowired
    private NewsService newsService;

    /**
     * 进入首页
     */
    @RequestMapping("/index")
    public String toIndex(Model model) {
        //获取商品分类
        List<ProductCategoryVo> productCategoryVoList = productCategoryService.queryAllProductCategory();
        //获取新闻
        NewsBO newsBO = new NewsBO();
        newsBO.setPage(true);
        newsBO.setPageSize(5);
        newsBO.setPageIndex(1);
        Pages<News> newsPages = newsService.queryNewsByPage(newsBO);

        //把数据保存到model中
        model.addAttribute("productCategoryVoList", productCategoryVoList);
        model.addAttribute("news", newsPages.getRecord());
        //转发index.jsp
        return "forward:/pre/index.jsp";
    }
}
