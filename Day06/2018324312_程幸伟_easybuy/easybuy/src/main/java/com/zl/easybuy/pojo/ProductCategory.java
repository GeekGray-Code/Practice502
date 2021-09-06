package com.zl.easybuy.pojo;

import lombok.Data;

/**
 * 分类信息类
 */
@Data
public class ProductCategory {
    private Integer id;
    private String name;
    private Integer parentId;
    private Integer type;
    private String iconClass;
}
