package com.icss.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Courier implements Serializable {
    private Integer id;
    private String name;
    private String courierTel;
    private String company;
    private Integer num;
}
