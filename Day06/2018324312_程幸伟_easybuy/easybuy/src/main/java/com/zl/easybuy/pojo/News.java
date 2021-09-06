package com.zl.easybuy.pojo;

import lombok.Data;

import java.util.Date;

/**
 * 新闻实体类
 */
@Data
public class News {
    private Integer id;
    private String title;
    private String content;
    private Date createTime;
}
