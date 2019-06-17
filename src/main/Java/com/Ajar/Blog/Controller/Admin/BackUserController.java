package com.Ajar.Blog.Controller.Admin;

import com.Ajar.Blog.Pojo.User;
import com.Ajar.Blog.Service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/Admin")
public class BackUserController {

    @Autowired
    UserService userService;

    @ResponseBody
    @RequestMapping("/getAllUser")
    public PageInfo getAllUser(@RequestParam("pn") Integer pn){

        //引入分页查询，使用PageHelper分页功能
        //在查询之前传入当前页，然后多少记录
        PageHelper.startPage(pn,8);
        //startPage后紧跟的这个查询就是分页查询
        List<User> UserList=userService.findAllUser();
        //使用PageInfo包装查询结果，只需要将pageInfo交给页面就可以
        PageInfo pageInfo = new PageInfo<>(UserList,5);
        return pageInfo;
    }

}
