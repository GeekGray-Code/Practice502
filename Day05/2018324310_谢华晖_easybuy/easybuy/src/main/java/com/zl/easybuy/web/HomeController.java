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
 


    
    public String  toIndex(Model model){
       
        List<ProductCategoryVo> productCategoryVoList =  productCategoryService.queryAllProductCategory();
        //准备新闻信息，分页查询
      


       //数据保存到model中
        model.addAttribute("productCategoryVoList",productCategoryVoList);
      

        return "forward:/pre/index.jsp";  
    }
}
