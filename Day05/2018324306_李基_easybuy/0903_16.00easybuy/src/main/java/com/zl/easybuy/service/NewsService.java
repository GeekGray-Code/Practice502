package com.zl.easybuy.service;/**
 * @author suke
 * @create 2021-09-03 14:46
 */

import com.zl.easybuy.pojo.News;
import com.zl.easybuy.util.Pages;

/**
 * TODO
 * @InterfaceName: NewsService
 * @author: suke
 * @since: 2021/9/3 14:46
 */
public interface NewsService {
    Pages<News> queryNewsByPage();
}
