package com.Ajar.Blog.Service;

import com.Ajar.Blog.Pojo.Article;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ArticleService {
    Article findArticleById(int id);
    List<Article> getTrueArticle();
    List<Article> findAllArticle();
    Boolean insertArticle(Article article);
    Boolean UpdateArticle(Article article);
    Boolean DeleteArticle(Integer articleId);
    List<Article> findHotArticle();
    List<Article> findArticleByTitle(String title);
}
