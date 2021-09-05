package com.zl.easybuy.util;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 分页实体类
 * @ClassName: Pages
 * @author: suke
 * @since: 2021/9/3 10:49
 */


public class Pages<T> {
    @Getter
    @Setter
    private Integer pageSize;
    @Getter
    @Setter
    private Integer pageIndex;
    @Getter
    @Setter
    private Long totalCount;//总记录

    private Long totalPages;// 总页数
    @Getter
    @Setter
    private List<T> record; //当前页记录

    public Long getTotalPages(){
        return  totalCount % pageSize == 0 ? totalCount/pageSize:totalCount/pageSize+1;
    }
}
