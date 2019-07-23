package com.sean.esearch.model;


import lombok.Data;
import lombok.ToString;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;
import java.util.Date;

/**
 * @author sean (yunfei_li@qq.com)
 * @version 1.0
 * @date 2019/7/16 10:34
 */
@Data
@ToString
@Document(indexName = "resource", type = "resources")
public class Resource implements Serializable {

    private Long id;

    @Field(type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")
    private String name;

    private String type;

    private Date createTime;

    private Date updateTime;

    @Field(type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")
    private String content;

    private String writer;

    @Field(type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")
    private String resource;

    private Date publishTime;

}
