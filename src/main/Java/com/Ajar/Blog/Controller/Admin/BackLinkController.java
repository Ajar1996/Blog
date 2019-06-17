package com.Ajar.Blog.Controller.Admin;

import com.Ajar.Blog.Pojo.Link;
import com.Ajar.Blog.Pojo.User;
import com.Ajar.Blog.Service.LinkService;
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
public class BackLinkController {

    @Autowired
    LinkService linkService;

    @Autowired
    Link link;

    @RequestMapping("/LinkManage")
    public String getAllLink(Model model){
        List<Link> linkList=linkService.getAllLink();
        model.addAttribute("LinkList",linkList);
        return "Admin/linklist";
    }
    /*
    改变友链的状态
     */
    @RequestMapping("/LinkStatus")
    @ResponseBody
    public Boolean ChangeLinkStatus(@RequestParam("linkId") Integer id){
        link.setLinkId(id);
        linkService.updateLinkStatus(linkService.getLink(link));
        return true;
    }

    /*
    修改友链
     */
    @RequestMapping("/UpdateLink")
    @ResponseBody
    public Boolean UpdateLink(@RequestBody Link link){
        linkService.updateLink(link);
        return true;
    }

    /*
    发布友链
     */
    @RequestMapping("/PublishLink")
    @ResponseBody
    public Boolean PublishLink(@RequestBody Link link){
        linkService.insertLink(link);
        return true;
    }

    /*
    删除友链
     */
    @RequestMapping("/DeleteLink")
    @ResponseBody
    public Boolean DeleteLink(@RequestParam("linkId")Integer id){
        link.setLinkId(id);
        linkService.deleteLink(link);
        return true;
    }
}
