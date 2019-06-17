package com.Ajar.Blog.Pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;
@Data
@Component
public class Comment {
    private Integer commentId;

    private Integer commentArticleId;

    private Integer commentAuthorName;

    private String commentContent;

    private Date commentCreateTime;

    private String commentAuthorImg;

    public Comment(Integer commentId, Integer commentArticleId, Integer commentAuthorName, String commentContent, Date commentCreateTime, String commentAuthorImg) {
        this.commentId = commentId;
        this.commentArticleId = commentArticleId;
        this.commentAuthorName = commentAuthorName;
        this.commentContent = commentContent;
        this.commentCreateTime = commentCreateTime;
        this.commentAuthorImg = commentAuthorImg;
    }

    public Comment() {
        super();
    }
}