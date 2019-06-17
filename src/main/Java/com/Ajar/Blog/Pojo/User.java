package com.Ajar.Blog.Pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;
@Data
@Component
public class User {
    private Integer userId;

    private String userName;

    private String userPass;

    private String userNickname;

    private String userEmail;

    private String userImg;

    private Date userRegisterTime;

    private Date userLastLoginTime;

    private Integer userStatus;

    public User(Integer userId, String userName, String userPass, String userNickname, String userEmail, String userImg, Date userRegisterTime, Date userLastLoginTime, Integer userStatus) {
        this.userId = userId;
        this.userName = userName;
        this.userPass = userPass;
        this.userNickname = userNickname;
        this.userEmail = userEmail;
        this.userImg = userImg;
        this.userRegisterTime = userRegisterTime;
        this.userLastLoginTime = userLastLoginTime;
        this.userStatus = userStatus;
    }

    public User() {
        super();
    }
}