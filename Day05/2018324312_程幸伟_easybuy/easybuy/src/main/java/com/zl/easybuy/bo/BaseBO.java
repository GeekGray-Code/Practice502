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
}
