package cn.yxd.controller;

import cn.yxd.bo.NewsBo;
import cn.yxd.pojo.News;
import cn.yxd.service.NewsService;
import cn.yxd.util.Pages;
import org.omg.CORBA.INTERNAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {

    @Autowired
    private NewsService newsService;
    @RequestMapping(value = "/admin/news/queryNewsList")
    public String adminNewList(@RequestParam(defaultValue = "1")Integer pageIndex, Model model){
        System.err.println("pageIndex"+pageIndex);
        //1、为了防止空指针异常，前端传过来的参数pageIndex必须默认是1
        //创建NewBo对象，设置分页参数
        NewsBo newsBo=new NewsBo();
        newsBo.setPageSize(6);
        newsBo.setPage(true);
        newsBo.setPageIndex(pageIndex);
        //创建Pages对象。用来存储数据

        Pages<News> pages = newsService.adminNewList(newsBo);
        //设置请求的url。加上系统的时间戳
        pages.setUrl("admin/news/queryNewsList?time="+System.currentTimeMillis());
        //将数据转发到 back/news/newList.jsp
        model.addAttribute("pager",pages);
        return  "/backend/news/newsList";

    }
}
