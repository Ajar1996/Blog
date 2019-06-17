package com.Ajar.Blog.Service.impl;

import com.Ajar.Blog.Dao.CommentMapper;
import com.Ajar.Blog.Pojo.Comment;
import com.Ajar.Blog.Pojo.CommentExample;
import com.Ajar.Blog.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentExample commentexample;

    @Autowired
    CommentMapper commentmapper;

    @Override
    public void addComment(Comment comment) {
        commentmapper.insert(comment);
    }

    @Override
    public List<Comment> findArticleComment(Integer articleID) {
        CommentExample commentExample=new CommentExample();
        CommentExample.Criteria criteria=commentExample.createCriteria();
        criteria.andCommentArticleIdEqualTo(articleID);
        List<Comment> commentList=commentmapper.selectByExample(commentExample);
        return commentList;

    }
}
