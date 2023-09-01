package com.icss.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Record implements Serializable {
    private Integer id;
    private Date time;
    private String type;
    private String position;
    private String address;
    private String person;
    private String tel;

    public Record(String position, String address, String person, String tel) {
        this.position = position;
        this.address = address;
        this.person = person;
        this.tel = tel;
    }
}
