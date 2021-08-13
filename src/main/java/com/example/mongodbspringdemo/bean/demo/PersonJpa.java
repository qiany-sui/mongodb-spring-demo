package com.example.mongodbspringdemo.bean.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * @author qianyuqi
 * @create 2021-08-13 09:35
 */
@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonJpa implements Serializable {
    @Id
    private String id;
    private String name;
    private Integer age;
}
