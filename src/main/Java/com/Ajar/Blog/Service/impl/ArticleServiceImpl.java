package com.Ajar.Blog.Service.impl;

import com.Ajar.Blog.Dao.ArticleMapper;
import com.Ajar.Blog.Pojo.Article;
import com.Ajar.Blog.Pojo.ArticleExample;
import com.Ajar.Blog.Service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleExample articleexample;
    @Autowired
    ArticleMapper articleMapper;

    /*
    当前时间
     */
    Date time= new java.sql.Date(new java.util.Date().getTime());

    @Override
    public Article findArticleById(int id) {
        Article article=articleMapper.selectByPrimaryKey(id);
        article.setArticleViewCount(article.getArticleViewCount()+1);
        articleMapper.updateByPrimaryKeySelective(article);
        return article;
    }

    @Override
    public List<Article> getTrueArticle() {
        ArticleExample articleExample=new ArticleExample();
        ArticleExample.Criteria criteria=articleExample.createCriteria();
        criteria.andArticleStatusEqualTo(1);
        return articleMapper.selectByExample(articleExample);
    }


    @Override
    public List<Article> findAllArticle() {
        return articleMapper.selectByExample(new ArticleExample());
    }

    @Override
    public Boolean insertArticle(Article article) {
        articleMapper.insertSelective(article);
        return true;
    }

    @Override
    public Boolean UpdateArticle(Article article) {
        articleMapper.updateByPrimaryKeySelective(article);
        return true;
    }

    @Override
    public Boolean DeleteArticle(Integer articleId) {
        articleMapper.deleteByPrimaryKey(articleId);
        return null;
    }

    @Override
    public List<Article> findHotArticle() {
        articleexample.setOrderByClause("article_view_count desc");
        return articleMapper.selectByExample(articleexample);
    }

    @Override
    public List<Article> findArticleByTitle(String titile) {
        ArticleExample articleExample=new ArticleExample();
        ArticleExample.Criteria criteria=articleExample.createCriteria();
        criteria.andArticleTitleLike("%"+titile+"%");
        List<Article> articleList=articleMapper.selectByExample(articleExample);
        return articleList;
    }
}
