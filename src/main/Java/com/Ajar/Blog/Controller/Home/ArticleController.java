package com.Ajar.Blog.Controller.Home;


import com.Ajar.Blog.Pojo.Article;
import com.Ajar.Blog.Pojo.Comment;
import com.Ajar.Blog.Service.ArticleService;
import com.Ajar.Blog.Service.CategoryService;
import com.Ajar.Blog.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private CategoryService categoryService;

    /**
     * 获取文章详情
     * @param articleId
     * @param model
     * @return
     */
    @RequestMapping("/article/{articleId}")
    public String getArticleDetail(@PathVariable("articleId") Integer articleId, Model model){
        Article article=articleService.findArticleById(articleId);
        List<Comment> commentList= commentService.findArticleComment(articleId);
        model.addAttribute("article",article);
        model.addAttribute("commonList",commentList);
        return "Home/detail";
    }


    /*
    搜索文章
     */
    @RequestMapping(value = "/SearchArticle",method= RequestMethod.GET)
    @ResponseBody
    public List<Article> SearchArticle(@RequestParam("title") String title, Model model){
        List<Article> article=articleService.findArticleByTitle(title);
        model.addAttribute("article",article);
        return article;
    }




}