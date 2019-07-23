package com.sean.esearch.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author sean (yunfei_li@qq.com)
 * @version 1.0
 * @date 2019/7/18 14:06
 */
@Data
public class Search implements Serializable {

    private String key;

    private String value;

    private String condition;

}
