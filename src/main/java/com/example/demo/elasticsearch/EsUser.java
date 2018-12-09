package com.example.demo.elasticsearch;

import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 使用SpringData的时候，它需要在实体类中设置indexName 和type ，
 * 如果和传统型数据库比较的话，就相当于库和表。
 * 需要注意的是indexName和type都必须是小写!!!
 */
@Document(indexName = "userindex", type = "user")
@Data
public class EsUser implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String name;
    private Integer age;
    private String desc;
    private Date creatTime;


}
