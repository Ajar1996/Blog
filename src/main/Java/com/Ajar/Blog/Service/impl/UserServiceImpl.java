package com.Ajar.Blog.Service.impl;

import com.Ajar.Blog.Dao.UserMapper;
import com.Ajar.Blog.Pojo.User;
import com.Ajar.Blog.Pojo.UserExample;
import com.Ajar.Blog.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;
    @Autowired
    User finduser;
    @Autowired
    UserExample userExample;

    /*
    当前时间
     */
    Date time= new java.sql.Date(new java.util.Date().getTime());

    @Override
    public User CheckUser(User user) {
        UserExample userExample=new UserExample();
        UserExample.Criteria Criteria = userExample.createCriteria();
        Criteria.andUserNameEqualTo(user.getUserName());
        Criteria.andUserPassEqualTo(user.getUserPass());
        List<User> userList = userMapper.selectByExample(userExample);
        if (userList.isEmpty()) {
            return finduser;
        }
        return  userList.get(0);
    }

    @Override
    public void UpdateLoginTime(User user) {
        user.setUserLastLoginTime(time);
        userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public List<User> findAllUser() {
        List<User> userList = userMapper.selectByExample(userExample);
        return userList;
    }

    @Override
    public void insertUser(User user) {
        user.setUserLastLoginTime(time);
        user.setUserRegisterTime(time);
        userMapper.insertSelective(user);
    }

    @Override
    public List<User> getTrueUser() {
        UserExample userExample=new UserExample();
        UserExample.Criteria criteria=userExample.createCriteria();
        criteria.andUserStatusEqualTo(1);
        return userMapper.selectByExample(userExample);
    }

    @Override
    public void updateUserStatus(User user) {
        user.setUserStatus((user.getUserStatus()==0)?1:0);
        userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public void deleteUser(User user) {
        userMapper.deleteByPrimaryKey(user.getUserId());
    }

    /*
   查找用户
    */
    @Override
    public User getUser(User user) {
        return userMapper.selectByPrimaryKey(user.getUserId());
    }
}