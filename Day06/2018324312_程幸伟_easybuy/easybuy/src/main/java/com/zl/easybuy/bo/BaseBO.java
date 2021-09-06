package com.zl.easybuy.bo;

import lombok.Data;

@Data
public abstract class BaseBO {
    /**
     * 是否分页
     */
    protected boolean isPage;
    /**
     * 分页开始序号
     */
    protected int startIndex;
    /**
     * 页容量
     */
    protected int pageSize;

    /**
     * 当前页码
     */
    protected int pageIndex;

    /**
     * 获得开始学号
     */
    public int getStartIndex() {
        if (pageIndex < 1) {
            return 0;
        }
        return (pageIndex - 1) * pageSize;
    }
}
