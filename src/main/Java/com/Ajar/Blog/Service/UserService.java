package com.Ajar.Blog.Service;

import com.Ajar.Blog.Pojo.User;

import java.util.List;

public interface UserService {
    User CheckUser(User user);
    void UpdateLoginTime(User user);
    List<User> findAllUser();
    void insertUser(User user);
    List<User> getTrueUser();
    void updateUserStatus(User user);
    void updateUser(User user);
    void deleteUser(User user);
    User getUser(User user);
}
