package com.icss.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.icss.mapper.ListMapper;
import com.icss.pojo.Cabinet;
import com.icss.service.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Service
public class ListServiceImpl implements ListService {
    @Autowired
    private ListMapper listMapper;
    @Override
    public PageInfo<Cabinet> selectList(int pageNum, int pageSize, String position, String courierName) {
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<>(listMapper.selectList(position,courierName));
    }
}
