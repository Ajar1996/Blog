package com.Ajar.Blog.Pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;
@Data
@Component
public class Article {
    private Integer articleId;

    private Integer articleUserId;

    private String articleTitle;

    private String articleContent;

    private Integer articleViewCount;

    private Integer articleCommentCount;

    private Date articleCreateTime;

    private Date articleUpdateTime;

    private String articleSummary;

    private String articleCategory;

    private Integer articleStatus;

    public Article(Integer articleId, Integer articleUserId, String articleTitle, String articleContent, Integer articleViewCount, Integer articleCommentCount, Date articleCreateTime, Date articleUpdateTime, String articleSummary, String articleCategory, Integer articleStatus) {
        this.articleId = articleId;
        this.articleUserId = articleUserId;
        this.articleTitle = articleTitle;
        this.articleContent = articleContent;
        this.articleViewCount = articleViewCount;
        this.articleCommentCount = articleCommentCount;
        this.articleCreateTime = articleCreateTime;
        this.articleUpdateTime = articleUpdateTime;
        this.articleSummary = articleSummary;
        this.articleCategory = articleCategory;
        this.articleStatus = articleStatus;
    }

    public Article() {
        super();
    }

    }