package com.icss.mapper;

import com.icss.pojo.Cabinet;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FetchMapper {
    void updateCabinetByGetCode(String getCode);
    void updateCabinet(String getCode,String usernameTel);
    Cabinet selectByPositionAndAddress(String usernameTel);
    /**
     * 根据usernameTel查getCode
     */
    Cabinet selectByUsernameTel(String usernameTel);
}
