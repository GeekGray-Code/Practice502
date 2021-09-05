package com.zl.easybuy.web;

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


@Controller
@RequestMapping("/Home")
public class HomeController {
   @Autowired
   private ProductCategoryService productCategoryService;
  /* @Autowired
   private NewsService newsService;*/


    /**
     * 进入首页
     */
    @RequestMapping("/index")
    public String  toIndex(Model model){
        //准备productCategoryVoList 所有的分类
        List<ProductCategoryVo> productCategoryVoList =  productCategoryService.queryAllProductCategory();





       //把数据保存到model中
        model.addAttribute("productCategoryVoList",productCategoryVoList);
       // model.addAttribute("news",newsPages.getRecord());

        return "forward:/pre/index.jsp";  //转发index.jsp
    }
}
