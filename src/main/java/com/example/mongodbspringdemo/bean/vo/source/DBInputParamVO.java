package com.example.mongodbspringdemo.bean.vo.source;

import lombok.Data;

/**
 * @author qianyuqi
 * @create 2021-07-20 15:03
 */
@Data
public class DBInputParamVO {
    // 字段名
    private String fieldName;
    // 字段描述
    private String fieldDesc;
    // 示例值
    private String exampleValue;
}
