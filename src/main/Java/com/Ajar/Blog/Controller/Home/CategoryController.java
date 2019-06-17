package com.Ajar.Blog.Controller.Home;

import com.Ajar.Blog.Pojo.Article;
import com.Ajar.Blog.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    Article article;

    @RequestMapping(value = "/CategoryArticle", method= RequestMethod.POST)
    @ResponseBody
    public List<Article> GetCategoryArticle(@RequestBody Article article)
    {
        List<Article> articleList=categoryService.findCategoryArticle(article);
        return articleList;
    }

}
