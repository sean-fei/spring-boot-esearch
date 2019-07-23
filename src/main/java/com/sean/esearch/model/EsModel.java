package com.sean.esearch.model;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * @author sean (yunfei_li@qq.com)
 * @version 1.0
 * @date 2019/7/22 10:03
 */
@Data
@ToString
public class EsModel {

    private String id;
    private String name;
    private int age;
    private Date date;

}
