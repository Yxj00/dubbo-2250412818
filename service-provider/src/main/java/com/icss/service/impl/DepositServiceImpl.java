package com.icss.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.icss.mapper.DepositMapper;
import com.icss.pojo.Cabinet;
import com.icss.pojo.Courier;
import com.icss.pojo.Record;
import com.icss.service.DepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Service
public class DepositServiceImpl implements DepositService {
    @Autowired
    private DepositMapper depositMapper;
    @Override
    public Cabinet selectById(String id) {
        return depositMapper.selectById(id);
    }

    @Override
    public List<String> selectCourierName() {
        return depositMapper.selectCourierName();
    }

    @Override
    public Courier selectByName(String name) {
        return depositMapper.selectByName(name);
    }

    @Override
    public void updateCabinet(Cabinet cabinet) {
        depositMapper.updateCabinet(cabinet);
    }

    @Override
    public void updateCourier(String name) {
        depositMapper.updateCourier(name);
    }

    @Override
    public void insertRecord(Record record) {
        depositMapper.insertRecord(record);
    }
}
