package com.zl.easybuy.pojo;

import lombok.Data;

import java.util.Date;

/**
 * 新闻实体类
 * @ClassName: News
 * @author: suke
 * @since: 2021/9/3 10:27
 */
@Data
public class News {
    private Integer id;
    private String title;
    private String content;
    //java.util,Date     实体类中使用java.util.Data
    private Date createTime;

}
