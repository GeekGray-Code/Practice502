package com.zl.easybuy.bo;

import lombok.Data;

/**
 * 业务对象的父类
 *
 * @ClassName: BaseBO
 * @author: suke
 * @since: 2021/9/3 15:18
 */
@Data
public abstract class BaseBO {
    private boolean isPage;// 是否使用分页: true 使用分页,  false, 不使用
    private int startIndex;// 分页查询开始序号
    private int pageSize; //页容量

}
