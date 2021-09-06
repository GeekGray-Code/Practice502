package com.zl.easybuy.pojo;

import lombok.Data;

/**
 * 商品信息表
 */
@Data
public class Product {
    private Integer id;
    private String name;
    private String description;
    private Double price;
    private Integer stock;
    private Integer categoryLevel1Id;//一级分类id
    private Integer categoryLevel2Id;//二级分类id
    private Integer categoryLevel3Id;//三级分类id
    private String fileName;//图片名
    private Integer  isDelete;
}
