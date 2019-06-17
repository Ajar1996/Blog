package com.Ajar.Blog.Service;

import com.Ajar.Blog.Pojo.Comment;

import java.util.List;

public interface CommentService {
    void addComment(Comment comment);
    List<Comment> findArticleComment(Integer articleID);
}
