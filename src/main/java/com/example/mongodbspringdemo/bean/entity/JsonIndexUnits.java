package com.example.mongodbspringdemo.bean.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * JSON字段 指标计算所有单元
 *
 * @date 2019-12-23 20:21:53
 */
@Data
public class JsonIndexUnits implements Serializable {

    private String index_info_uuid;

    private String index_info_name;

    private String unit_uuid;

    private String unit_type;
}
