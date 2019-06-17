package com.Ajar.Blog.Controller.Admin;

import com.Ajar.Blog.Pojo.Notice;
import com.Ajar.Blog.Service.NoticeService;
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
public class BackNoticeController {

    @Autowired
    NoticeService noticeService;

    @Autowired
    Notice notice;
    /*
    获取所有公告
     */
    @RequestMapping("/NoticeManage")
    public String getALLNotice(Model model){
        List<Notice> NoticeList=noticeService.getAllNotice();
        model.addAttribute("NoticeList",NoticeList);
        return "Admin/noticelist";
    }
    /*
    改变公告的状态
     */
    @RequestMapping("/NoticeStatus")
    @ResponseBody
    public Boolean ChangeNoticeStatus(@RequestParam("noticeId") Integer id){
        notice.setNoticeId(id);
        noticeService.updateNoticeStatus(noticeService.getNotice(notice));
        return true;
    }

    /*
    修改公告
     */
    @RequestMapping("/UpdateNotice")
    @ResponseBody
    public Boolean UpdateNotice(@RequestBody Notice notice){
        noticeService.updateNotice(notice);
        return true;
    }

    /*
    发布公告
     */
    @RequestMapping("/PublishNotice")
    @ResponseBody
    public Boolean PublishNotice(@RequestBody Notice notice){
        noticeService.insertNotice(notice);
        return true;
    }

    /*
    删除公告
     */
    @RequestMapping("/DeleteNotice")
    @ResponseBody
    public Boolean DeleteNotice(@RequestParam("noticeId")Integer id){
        notice.setNoticeId(id);
        noticeService.deleteNotice(notice);
        return true;
    }
}
