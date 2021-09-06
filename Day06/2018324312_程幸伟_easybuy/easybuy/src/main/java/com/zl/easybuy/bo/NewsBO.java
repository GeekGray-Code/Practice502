package com.zl.easybuy.bo;

import com.zl.easybuy.pojo.News;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 新闻的条件类
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class NewsBO extends BaseBO {
    private News news;
}
