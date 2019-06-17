package com.Ajar.Blog.Service.impl;

import com.Ajar.Blog.Dao.ArticleMapper;
import com.Ajar.Blog.Dao.CategoryMapper;
import com.Ajar.Blog.Pojo.*;
import com.Ajar.Blog.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryMapper categoryMapper;

    @Autowired
    CategoryExample categoryExample;

    @Autowired
    ArticleExample articleExample;

    @Autowired
    ArticleMapper articleMapper;

    /*
    当前时间
     */
    Date time= new java.sql.Date(new java.util.Date().getTime());
    /*
    查询所有分类
     */
    @Override
    public List<Category> findAllCategory() {
        List<Category> categoryList=categoryMapper.selectByExample(categoryExample);
        return categoryList;
    }

    /*
    查询对应分类的文章
     */
    @Override
    public List<Article> findCategoryArticle(Article article) {
         ArticleExample articleExample=new ArticleExample();
         ArticleExample.Criteria criteria =articleExample.createCriteria();
         criteria.andArticleCategoryEqualTo(article.getArticleCategory());
         List<Article> articleList=articleMapper.selectByExample(articleExample);
        return articleList;
    }
    /*
    更新分类
     */
    @Override
    public void updateCategory(Category category) {
       category.setCategoryUpdateTime(time);
       categoryMapper.updateByPrimaryKeySelective(category);
    }
    /*
    删除分类
     */
    @Override
    public void deleteCategory(Category category) {
        categoryMapper.deleteByPrimaryKey(category.getCategoryId());
    }
    /*
    新建分类
     */
    @Override
    public void insertCategory(Category category) {
        category.setCategoryUpdateTime(time);
        category.setCategoryCreateTime(time);
        categoryMapper.insertSelective(category);
    }

    /*
    获取status不为0的分类
     */
    @Override
    public List<Category> getTrueCategory() {
        CategoryExample categoryExample=new CategoryExample();
        CategoryExample.Criteria criteria=categoryExample.createCriteria();
        criteria.andCategoryStatusEqualTo(1);
        return categoryMapper.selectByExample(categoryExample);
    }
}
