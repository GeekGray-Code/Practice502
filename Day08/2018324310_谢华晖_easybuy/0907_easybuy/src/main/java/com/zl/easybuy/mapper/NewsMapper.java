package com.zl.easybuy.mapper;
import com.zl.easybuy.bo.NewsBO;
import com.zl.easybuy.pojo.News;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NewsMapper {
    /**
     * 查询记录数
     * @param newsBO
     * @return
     */
    Long count(@Param("newsBO") NewsBO newsBO);

    /**
     * 分页查询当前页记录
     * @param newsBO
     * @return
     */
    List<News> queryByPage(@Param("newsBO")NewsBO newsBO);
}
