package com.Ajar.Blog.Controller.Admin;

import com.Ajar.Blog.Pojo.Article;
import com.Ajar.Blog.Service.ArticleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/Admin")
public class BackAdmin {

    @Autowired
    ArticleService articleService;

    /*
    跳转到文章列表
     */
    @RequestMapping("/ArticleManage")
    public String ToArticleManage(Model model){
        PageHelper.startPage(1,8);
        //startPage后紧跟的这个查询就是分页查询
        List<Article> articleList= this.articleService.getTrueArticle();
        //使用PageInfo包装查询结果，只需要将pageInfo交给页面就可以
        PageInfo pageInfo = new PageInfo<>(articleList,5);
        model.addAttribute(pageInfo);
        return "Admin/datalist";
    }

    /*
    发布文章
     */
    @RequestMapping("/ArticleEdtior")
    public String ToArticleEdtior(){
        return "Admin/editor";
    }

    /*
    后台主页
     */
    @RequestMapping("/Main")
    public String ToBackIndex(){
        return "/Admin/main";
    }

    @RequestMapping("/UserManage")
    public String ToUserList(){
        return "Admin/userlist";
    }
}
