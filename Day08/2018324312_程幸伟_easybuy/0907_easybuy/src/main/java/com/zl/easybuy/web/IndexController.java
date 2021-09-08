package cn.yxd.controller;

import cn.yxd.bo.ProductBo;
import cn.yxd.pojo.News;
import cn.yxd.pojo.Product;
import cn.yxd.service.NewsService;
import cn.yxd.service.ProductCategoryService;
import cn.yxd.service.ProductService;
import cn.yxd.util.Pages;
import cn.yxd.vo.ProductCategoryVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class IndexController {
    @Autowired
    private ProductCategoryService categoryService;
    @Autowired
    private NewsService newsService;
    @Autowired
    private ProductService productService;


    /**
     * 这里是跳转到主页
     */
    @RequestMapping(value = "/Home/index")
    public String getIndex(Model model) {

        //在这里是新增加了新闻列表

        //查询出商品分类的所有信息，
        List<ProductCategoryVo> categoryList = categoryService.getCategoryList();
        //查询出新闻的信息，然后对其进行分页
        model.addAttribute("productCategoryVoList", categoryList);
        List<News> listnew = newsService.newsList();
        model.addAttribute("news", listnew);
        //转发到首页
        return "/pre/index";
    }

    //在搜索框内输入查询商品的名称输入数据
    //或者是根据一二级分类的id进行查询数据
    //然后对其进行分页 ,具体的做法和上面是一样的
    @RequestMapping(value = "/Product/queryProductList")
    //category 传过来的产品种类的id，level 穿过来的分类的标识，keyWord：关键字，pageIndex当前页
    public String queryProductList(Integer category, @RequestParam(value = "level", defaultValue = "1") Integer level, String keyWord, @RequestParam(value = "pageIndex", defaultValue = "1") Integer pageIndex, Model model) {
        //使用ProductBo进行封装数据
        ProductBo productBo = new ProductBo();
        //设置分页大小
        productBo.setPageSize(6);
        //开启分页
        productBo.setPage(true);
        productBo.setPageIndex(pageIndex);
        //调用service的方法，对其进行分页查询，以及进行关键字搜素等
        Product product = new Product();
        //我们要设置产品的名称
        product.setName(keyWord);
        productBo.setProduct(product);
        //判断前端传过来的是那种等级分类,可能是一级分类，二级分类，或者是三级分类
        switch (level) {
            //level:1 表示一级分类 ，需要设置1级分类category:产品的id
            case 1:
                product.setCategoryLevel1Id(category);
            case 2:
                product.setCategoryLevel2Id(category);
            case 3:
                product.setCategoryLevel3Id(category);

        }
        //将数据传入到Model中

        List<ProductCategoryVo> ProductCategoryVo = categoryService.getCategoryList();
        model.addAttribute("productCategoryVoList", ProductCategoryVo);
        //封装这个属性${keyWord}
        model.addAttribute("keyWord", keyWord);
        //同时将productCategoryVoList传入到页面上，在使用category的时候要用\
        Pages<Product> productPages = productService.productPages(productBo);
        productPages.setUrl(linkUrl(keyWord, category, level));
        model.addAttribute("pager", productPages);
        return "forward:/pre/product/queryProductList.jsp";

    }

    //拼接url
    public String linkUrl(String keyword, Integer category, Integer level) {

        long l = System.currentTimeMillis();

        StringBuffer url = new StringBuffer("/Product/queryProductList?time=" + l);
        StringBuffer buffer = new StringBuffer();
        if (category != null) {
            buffer.append("&category=" + category);
        }
        if (keyword != null && !(keyword.equals(""))) {
            buffer.append("&keyword=" + keyword);
        }
        if (level != null) {
            buffer.append("&level=" + level);
        }
        StringBuffer append = url.append(buffer);
        System.out.println("append的结果是" + append);
        System.out.println("append.toString()" + append.toString());
        return append.toString();
    }

    //根据商品的id查询相关的信息
    @RequestMapping("/Product/queryProductDeatil")
    public String queryProduct(Integer id,Model model) {
        Product product=productService.queryProduct(id);
        model.addAttribute("product",product);
        return "forward:/pre/product/productDeatil.jsp";
    }
    //跳转到登录界面 /User/Login
    @RequestMapping(value = "/User/LoginView")
    public String loginView(){

        return "forward:/pre/login.jsp";
    }


}
