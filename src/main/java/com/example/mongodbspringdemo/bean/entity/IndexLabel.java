package com.example.mongodbspringdemo.bean.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 指标与计算单元
 *
 * @date 2019-12-21 17:06:42
 */
@Data
public class IndexLabel implements Serializable {

    /**
     * 指标uuid
     */
    private String indexUuid;
    /**
     * 标签 uuid
     */
    private String labelId;
    /**
     * 标签名称
     */
    private String labelName;
    /**
     * 创建者
     */
    private String createUser;
    /**
     * 更新者
     */
    private String updateUser;
    /**
     * 数据源创建日期
     */
    private Date createTime;


    private Date datachangeLasttime;

}
