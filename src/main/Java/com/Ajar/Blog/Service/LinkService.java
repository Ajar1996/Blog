package com.Ajar.Blog.Service;

import com.Ajar.Blog.Pojo.Link;

import java.util.List;

public interface LinkService {
    List<Link> getAllLink();
    void insertLink(Link link);
    List<Link> getTrueLink();
    void updateLinkStatus(Link link);
    void updateLink(Link link);
    void deleteLink(Link link);
    Link getLink(Link link);
}
