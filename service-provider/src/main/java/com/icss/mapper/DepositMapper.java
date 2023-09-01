package com.icss.mapper;

import com.icss.pojo.Cabinet;
import com.icss.pojo.Courier;
import com.icss.pojo.Record;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DepositMapper {
    Cabinet selectById(String id);
    List<String> selectCourierName();
    Courier selectByName(String name);
    void updateCabinet(Cabinet cabinet);
    void updateCourier(String name);
    void insertRecord(Record record);

}
