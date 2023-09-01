package com.icss.service;

import com.icss.pojo.Cabinet;

public interface FetchService {

    void updateCabinet(String getCode,String usernameTel);

    Cabinet selectByPositionAndAddress(String usernameTel);

    /**
     * 根据usernameTel查getCode
     */
    Cabinet selectByUsernameTel(String usernameTel);
}
