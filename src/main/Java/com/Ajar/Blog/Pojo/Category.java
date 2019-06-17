package com.Ajar.Blog.Pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;
@Data
@Component
public class Category {
    private Integer categoryId;

    private String categoryName;

    private Date categoryCreateTime;

    private Date categoryUpdateTime;

    private Integer categoryStatus;

    public Category(Integer categoryId, String categoryName, Date categoryCreateTime, Date categoryUpdateTime, Integer categoryStatus) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.categoryCreateTime = categoryCreateTime;
        this.categoryUpdateTime = categoryUpdateTime;
        this.categoryStatus = categoryStatus;
    }

    public Category() {
        super();
    }
}