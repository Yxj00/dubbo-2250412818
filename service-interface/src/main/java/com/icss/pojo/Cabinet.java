package com.icss.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cabinet implements Serializable {
    private Integer id;
    private String position;
    private String address;
    private Integer status;
    private String courierNumber;// 快递单号
    private String courierName;
    private String getCode;// 取件码
    private String username;
    private String usernameTel;

    private Courier courier;

}
