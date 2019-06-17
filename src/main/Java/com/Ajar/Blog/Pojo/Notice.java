package com.Ajar.Blog.Pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;
@Data
@Component
public class Notice {
    private Integer noticeId;

    private String noticeTitle;

    private String noticeContent;

    private Date noticeCreateTime;

    private Date noticeUpdateTime;

    private Integer noticeStatus;

    public Notice(Integer noticeId, String noticeTitle, String noticeContent, Date noticeCreateTime, Date noticeUpdateTime, Integer noticeStatus) {
        this.noticeId = noticeId;
        this.noticeTitle = noticeTitle;
        this.noticeContent = noticeContent;
        this.noticeCreateTime = noticeCreateTime;
        this.noticeUpdateTime = noticeUpdateTime;
        this.noticeStatus = noticeStatus;
    }

    public Notice() {
        super();
    }

 }