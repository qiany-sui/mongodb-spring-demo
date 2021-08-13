package com.example.mongodbspringdemo.bean.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 标签
 *
 * @date 2019-12-21 17:06:42
 */
@Data
public class Label implements Serializable {
    private String labelUuid;
    /**
     * 标签名称
     */
    private String labelName;
    /**
     * 使用频率/次数
     */
    private Integer frequency;
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
    /**
     *
     */
    private Date datachangeLasttime;

}
