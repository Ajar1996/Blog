package com.Ajar.Blog.Controller.Home;

import com.Ajar.Blog.Pojo.Comment;
import com.Ajar.Blog.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
public class CommentController {

    @Autowired
    CommentService commentService;
    /*
    回复文章
     */
    @RequestMapping("/commentArticle")
    @ResponseBody
    public Comment CommentArticle(@RequestBody Comment comment, HttpServletRequest request)
    {
            Date time= new java.sql.Date(new java.util.Date().getTime());
            comment.setCommentCreateTime(time);
            commentService.addComment(comment);
            return comment;
    }




}
