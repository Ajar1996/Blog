package com.Ajar.Blog.Service;

import com.Ajar.Blog.Pojo.Notice;

import java.util.List;

public interface NoticeService {
    List<Notice> getAllNotice();
    void insertNotice(Notice notice);
    List<Notice> getTrueNotice();
    void updateNotice(Notice notice);
    void deleteNotice(Notice notice);
    void updateNoticeStatus(Notice notice);
    Notice getNotice(Notice notice);
}
