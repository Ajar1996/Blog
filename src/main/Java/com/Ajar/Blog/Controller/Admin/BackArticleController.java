package com.Ajar.Blog.Controller.Admin;

import com.Ajar.Blog.Pojo.Article;
import com.Ajar.Blog.Pojo.User;
import com.Ajar.Blog.Service.ArticleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/Admin")
public class BackArticleController {

    @Autowired
    ArticleService articleService;

    /*
    发表文章
     */
    @ResponseBody
    @RequestMapping("/publish")
    public boolean PublishEditor(@RequestBody Article article, HttpServletRequest request)
    {

        if (null!=article.getArticleId()){
            articleService.UpdateArticle(article);
        }
        else {
        Date time= new java.sql.Date(new java.util.Date().getTime());
        article.setArticleCreateTime(time);
        User user =(User) request.getSession().getAttribute("user");
        article.setArticleUserId(user.getUserId());
        articleService.insertArticle(article);
        }
        return true;
    }

    /*
    加载文章列表
     */
    @ResponseBody
    @RequestMapping("/ArticleList")
    public PageInfo toArticleList(@RequestParam(required = true)Integer pn) {
        //引入分页查询，使用PageHelper分页功能
        //在查询之前传入当前页，然后多少记录
        PageHelper.startPage(pn,8);
        //startPage后紧跟的这个查询就是分页查询
        List<Article> articleList= this.articleService.findAllArticle();
        //使用PageInfo包装查询结果，只需要将pageInfo交给页面就可以
        PageInfo pageInfo = new PageInfo<>(articleList,5);
        return pageInfo;
    }


    /*
    编辑已有的文章
     */
    @RequestMapping(value = "/ArticleEdit" ,method= RequestMethod.GET)
    public String toIndex(@RequestParam("articleId") Integer articleId,Model model) {
        Article article=articleService.findArticleById(articleId);
        model.addAttribute(article);
        return "Admin/editor";
    }

    /*
    删除文章
     */
    @ResponseBody
    @RequestMapping("/ArticleDelete")
    public Boolean ArticleDelete(@RequestParam(required = true)Integer articleId) {
        articleService.DeleteArticle(articleId);
        return true;
    }



}
