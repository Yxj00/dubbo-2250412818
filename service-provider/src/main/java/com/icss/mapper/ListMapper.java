package com.icss.mapper;

import com.icss.pojo.Cabinet;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ListMapper {
    /**
     * 快递柜列表
     * @return
     */
    List<Cabinet> selectList(@Param("position") String position,@Param("courierName") String courierName);
}
