package com.Ajar.Blog.Service.impl;

import com.Ajar.Blog.Dao.LinkMapper;
import com.Ajar.Blog.Pojo.Link;
import com.Ajar.Blog.Pojo.LinkExample;
import com.Ajar.Blog.Service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/*
友情链接
 */
@Service
public class LinkServiceImpl implements LinkService {

    @Autowired
    LinkMapper linkMapper;

    @Autowired
    LinkExample linkExample;

    /*
    当前时间
     */
    Date time= new java.sql.Date(new java.util.Date().getTime());
    /*
   查询所有友链
    */
    @Override
    public List<Link> getAllLink() {
        return linkMapper.selectByExample(linkExample);
    }
    /*
        插入友链
         */
    @Override
    public void insertLink(Link link) {
        link.setLinkUpdateTime(time);
        link.setLinkCreateTime(time);
        linkMapper.insertSelective(link);
    }
    /*
       获取status为1的友链
        */
    @Override
    public List<Link> getTrueLink() {
        LinkExample linkExample=new LinkExample();
        LinkExample.Criteria criteria=linkExample.createCriteria();
        criteria.andLinkStatusEqualTo(1);
        return linkMapper.selectByExample(linkExample);
    }
    /*
       更新友链状态
        */
    @Override
    public void updateLinkStatus(Link link) {
        link.setLinkStatus((link.getLinkStatus()==0)?1:0);
        link.setLinkUpdateTime(time);
        linkMapper.updateByPrimaryKeySelective(link);
    }
    /*
        更新友链
         */
    @Override
    public void updateLink(Link link) {
        link.setLinkUpdateTime(time);
        linkMapper.updateByPrimaryKeySelective(link);
    }
    /*
        删除友链
         */
    @Override
    public void deleteLink(Link link) {
        linkMapper.deleteByPrimaryKey(link.getLinkId());
    }
    /*
    查找友联
     */
    @Override
    public Link getLink(Link link) {
        return linkMapper.selectByPrimaryKey(link.getLinkId());
    }
}
