package com.zl.easybuy.util;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 分页实体类
 */
@Getter
@Setter
public class Pages<T> {
    private Integer pageSize;
    private Integer pageIndex;
    /**
     * 总记录
     */
    private Long totalCount;
    /**
     * 总页数
     */
    private Long totalPages;
    /**
     * 当前页记录
     */
    private List<T> record;
    /**
     * 页码的url
     */
    private String url;

    public Long getTotalPages() {
        return totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1;
    }
}
