package com.example.mongodbspringdemo.bean.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * JSON 示例表
 *
 * @date 2019-12-21 17:06:42
 */
@Data
public class JsonDemo implements Serializable {

    /**
     * api 源 uuid
     */
    private String apiId;
    /**
     * 源名称
     */
    private String sourceName;
    /**
     * 数据来源：001-元素：ele,002-汇法网：law,003-启信宝：qxb,004-发票：fp,301-S3：s3,302-HDFS：hdfs
     */
    private String sourceType;
    /**
     *
     */
    private String sourceCode;
    /**
     * 数据来源
     */
    private String sourcePath;
    /**
     * 接口/版本编号
     */
    private String sourceNo;
    /**
     * JSON 示例
     */
    private String jsonStr;
    /**
     * 备注/说明
     */
    private String remark;
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

    /**
     * 更新者
     */
    private String requestParams;

    /**
     * 数据源创建日期
     */
    private String requestMeta;
    private String schemaMeta;
    private String apiKey;

}
