package com.icss.service;

import com.github.pagehelper.PageInfo;
import com.icss.pojo.Cabinet;

public interface ListService {
    /**
     * 快递柜列表  分页加模糊查询
     * @return
     */
    PageInfo<Cabinet> selectList(int pageNum, int pageSize, String position, String courierName);
}
