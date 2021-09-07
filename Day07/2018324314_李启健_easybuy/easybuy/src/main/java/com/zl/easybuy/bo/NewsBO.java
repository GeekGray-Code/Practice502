package com.zl.easybuy.bo;

import com.zl.easybuy.pojo.News;
import lombok.Data;

/**
 * 新闻的条件类
 * @ClassName: NewsBO
 * @author: suke
 * @since: 2021/9/6 9:23
 */
@Data
public class NewsBO extends BaseBO {
    private News news;
}
