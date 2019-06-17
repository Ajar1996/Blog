package com.Ajar.Blog.Service;

import com.Ajar.Blog.Pojo.Article;
import com.Ajar.Blog.Pojo.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAllCategory();
    List<Article> findCategoryArticle(Article article);
    void updateCategory(Category category);
    void deleteCategory(Category category);
    void insertCategory(Category category);
    List<Category> getTrueCategory();
}
