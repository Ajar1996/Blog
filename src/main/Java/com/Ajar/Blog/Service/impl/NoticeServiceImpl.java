package com.Ajar.Blog.Service.impl;

import com.Ajar.Blog.Dao.NoticeMapper;
import com.Ajar.Blog.Pojo.Notice;
import com.Ajar.Blog.Pojo.NoticeExample;
import com.Ajar.Blog.Service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    NoticeMapper noticeMapper;

    @Autowired
    NoticeExample noticeExample;
    /*
    当前时间
     */
    Date time= new java.sql.Date(new java.util.Date().getTime());
    /*
    查询所有公告
     */
    @Override
    public List<Notice> getAllNotice() {
        return noticeMapper.selectByExample(noticeExample);
    }


    /*
    插入公告
     */
    @Override
    public void insertNotice(Notice notice) {
        notice.setNoticeCreateTime(time);
        notice.setNoticeUpdateTime(time);
        noticeMapper.insertSelective(notice);


    }

    /*
    获取status为1的公告
     */
    @Override
    public List<Notice> getTrueNotice() {
        NoticeExample noticeExample=new NoticeExample();
        NoticeExample.Criteria criteria=noticeExample.createCriteria();
        criteria.andNoticeStatusEqualTo(1);
        return noticeMapper.selectByExample(noticeExample);
    }

    /*
    更新公告
     */
    @Override
    public void updateNotice(Notice notice) {
        notice.setNoticeUpdateTime(time);
        noticeMapper.updateByPrimaryKeySelective(notice);
    }

 /*
    更新公告状态
     */
    @Override
    public void updateNoticeStatus(Notice notice) {
        notice.setNoticeStatus((notice.getNoticeStatus()==0)?1:0);
        notice.setNoticeUpdateTime(time);
        noticeMapper.updateByPrimaryKeySelective(notice);
    }

    @Override
    public Notice getNotice(Notice notice) {
        return noticeMapper.selectByPrimaryKey(notice.getNoticeId());
    }

    /*
    删除公告
     */
    @Override
    public void deleteNotice(Notice notice) {
        noticeMapper.deleteByPrimaryKey(notice.getNoticeId());
    }



}
