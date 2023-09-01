package com.icss.service;

import com.icss.pojo.Cabinet;
import com.icss.pojo.Courier;
import com.icss.pojo.Record;

import java.util.List;

public interface DepositService {
    Cabinet selectById(String id);
    List<String> selectCourierName();
    Courier selectByName(String name);
    void updateCabinet(Cabinet cabinet);
    void updateCourier(String name);
    void insertRecord(Record record);
}
