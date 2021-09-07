package com.zl.easybuy.web;

import com.zl.easybuy.bo.ProductBO;
import com.zl.easybuy.pojo.Product;
import com.zl.easybuy.service.ProductCategoryService;
import com.zl.easybuy.service.ProductService;
import com.zl.easybuy.util.Pages;
import com.zl.easybuy.vo.ProductCategoryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/Product")
public class ProductController {
   @Autowired
   private ProductService productService;
   @Autowired
   private ProductCategoryService productCategoryService;



    @RequestMapping("/queryProductList")
    public  String  queryProductList(Integer category,  @RequestParam(defaultValue = "1") Integer level, String  keyWord, @RequestParam(defaultValue = "1") Integer pageIndex, Model model){
        ProductBO productBO = new ProductBO();
        Product product = new Product();
        product.setName(keyWord);
      switch(level){
          case 1:
              product.setCategoryLevel1Id(category);
              break;
          case 2:
              product.setCategoryLevel2Id(category);
              break;
          case 3:
              product.setCategoryLevel3Id(category);
              break;
          default:
             break;
      }
      productBO.setProduct(product);
      productBO.setPage(true);
      productBO.setPageIndex(pageIndex);
      productBO.setPageSize(6);
      Pages<Product> pages =  productService.queryByPage(productBO);
      /*
      * 构建分页页码的url
      * */
      pages.setUrl(createUrl(category,level,keyWord));
      model.addAttribute("pager",pages);

      //查询商品分类
        List<ProductCategoryVo> productCategoryVos = productCategoryService.queryAllProductCategory();
        model.addAttribute("productCategoryVoList",productCategoryVos);
        //保存关键字
        model.addAttribute("keyWord",keyWord);
        return "forward:/pre/product/queryProductList.jsp";
    }

    private String createUrl(Integer category, Integer level, String  keyWord){
        StringBuffer url = new StringBuffer("Product/queryProductList?time=");
        url.append(System.currentTimeMillis());
        if(category != null){
            url.append("&category=").append(category);
        }
        if(level != null){
            url.append("&level=").append(level);
        }
        if(keyWord != null && !keyWord.isEmpty()){
            url.append("&keyWord=").append(keyWord);
        }
        return url.toString();
    }



    @RequestMapping("/queryProductDeatil")
    public  String queryProductDeatil(Integer id,Model model){
        Product product = productService.queryById(id);
        model.addAttribute("product",product);
        //查询商品分类
        List<ProductCategoryVo> productCategoryVos = productCategoryService.queryAllProductCategory();
        model.addAttribute("productCategoryVoList",productCategoryVos);
        return "forward:/pre/product/productDeatil.jsp";

    }

}
