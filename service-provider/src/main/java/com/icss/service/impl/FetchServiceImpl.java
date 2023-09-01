package com.icss.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.icss.mapper.FetchMapper;
import com.icss.pojo.Cabinet;
import com.icss.service.FetchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Service
public class FetchServiceImpl implements FetchService {
    @Autowired
    private FetchMapper fetchMapper;

    @Override
    public void updateCabinet(String getCode,String usernameTel) {
        fetchMapper.updateCabinet(getCode,usernameTel);
    }

    @Override
    public Cabinet selectByPositionAndAddress(String usernameTel) {
        return fetchMapper.selectByPositionAndAddress(usernameTel);
    }

    @Override
    public Cabinet selectByUsernameTel(String usernameTel) {
        return fetchMapper.selectByUsernameTel(usernameTel);
    }
}
