package com.example.mongodbspringdemo.bean.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author qianyuqi
 * @create 2021-08-12 19:48
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person implements Serializable {
    private String id;
    private String name;
    private int age;
}
