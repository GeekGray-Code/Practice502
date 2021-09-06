package com.zl.easybuy.util;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 分页实体类
 * 
 */

@Getter
@Setter
public class Pages<T> {
    private Integer pageSize;
    private Integer pageIndex;
    private Long totalCount;//总记录
    //private Long totalPages;// 总页数
    private List<T> record; //当前页记录
    private String url;//页码的url

    public Long getTotalPages(){
        return  totalCount % pageSize == 0 ? totalCount/pageSize:totalCount/pageSize+1;
    }
}
