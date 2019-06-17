package com.Ajar.Blog.Pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;
@Data
@Component
public class Link {
    private Integer linkId;

    private String linlName;

    private String linkUrl;

    private Date linkUpdateTime;

    private Date linkCreateTime;

    private Integer linkStatus;

    public Link(Integer linkId, String linlName, String linkUrl, Date linkUpdateTime, Date linkCreateTime, Integer linkStatus) {
        this.linkId = linkId;
        this.linlName = linlName;
        this.linkUrl = linkUrl;
        this.linkUpdateTime = linkUpdateTime;
        this.linkCreateTime = linkCreateTime;
        this.linkStatus = linkStatus;
    }

    public Link() {
        super();
    }
}