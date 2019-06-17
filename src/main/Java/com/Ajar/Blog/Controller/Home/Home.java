package com.Ajar.Blog.Controller.Home;

import com.Ajar.Blog.Pojo.Article;
import com.Ajar.Blog.Pojo.Category;
import com.Ajar.Blog.Pojo.Link;
import com.Ajar.Blog.Pojo.Notice;
import com.Ajar.Blog.Service.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class Home {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private NoticeService noticeService;

    @Autowired
    private LinkService linkService;

    /*
    跳转到首页
     */
    @RequestMapping("/index")
    public String toIndex(@RequestParam(required = false,defaultValue = "1",value = "pn")Integer pn, Model model, HttpServletRequest request) {
        //引入分页查询，使用PageHelper分页功能
        //在查询之前传入当前页，然后多少记录
        PageHelper.startPage(pn,10);
        //startPage后紧跟的这个查询就是分页查询
        List<Article> articleList= this.articleService.findAllArticle();
        //热文排行
        List<Article> hotArticle=articleService.findHotArticle();
        //分类
        List<Category> categoryList=categoryService.findAllCategory();
        List<Notice> noticeList=noticeService.getAllNotice();
        //友情链接
        List<Link> linkList=linkService.getAllLink();
        //使用PageInfo包装查询结果，只需要将pageInfo交给页面就可以
        PageInfo pageInfo = new PageInfo<>(articleList,5);
        //pageINfo封装了分页的详细信息，也可以指定连续显示的页数
        model.addAttribute("pageInfo",  pageInfo);
        model.addAttribute("noticeList",noticeList);
        request.getSession().setAttribute("hotArticle",hotArticle);
        request.getSession().setAttribute("categoryList",categoryList);
        request.getSession().setAttribute("linkList",linkList);
        return "Home/home";
    }

    /*
 跳转到文章专栏
  */
    @RequestMapping("/articleCategory")
    public String toArticleGategory(){
        return "Home/article";
    }

    /*
    跳转到资源分享
     */
    @RequestMapping("/resource")
    public String toResource(){
        return "Home/resource";
    }

    /*
    跳转到关于本站
     */
    @RequestMapping("/about")
    public String toAbout(){
        return "Home/about";
    }

    /*
    跳转到点点滴滴
     */
    @RequestMapping("/timeline")
    public String toTimeLine(){
        return "Home/timeline";
    }

}
