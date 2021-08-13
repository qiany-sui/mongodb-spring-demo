package com.example.mongodbspringdemo.bean.vo.source;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 数据源表
 *
 * @date 2019-12-21 17:06:42
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SourceInfo implements Serializable {

    private String dcId;

    /**
     * 数据源 uuid
     */
    private String sourceUuid;
    /**
     * 数据源名称
     */
    private String sourceName;
    /**
     * 数据来源： 000-api,100-数据库：db,200-Excel：excel,300-分布式
     */
    private String sourceType;
    /**
     *
     */
    private String sourceCode;
    /**
     * 数据来源：001-元素：ele,002-汇法网：law,003-启信宝：qxb,004-发票：fp,301-S3：s3,302-HDFS：hdfs
     */
    private String subType;
    /**
     * JSON 示例 ID,关联 JSON 示例表
     */
    private String apiId;
    /**
     * api/excel版本号/数据库版本号
     */
    private String version;
    /**
     * 数据源地址/路径/excel存储地址
     */
    private String sourcePath;
    /**
     * 账号（凭证号）
     */
    private String account;
    /**
     * 密码（密匙）
     */
    private String password;
    /**
     * 驱动
     */
    private String driver;
    /**
     * 是否遍历:0-遍历,1-不遍历
     */
    private Integer isTraversal;
    /**
     * 数据源描述
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
    private String createTime;

    private String datachangeLasttime;

    private String schemaName;

    private String nameSpace;

    private String field;

    private String columns;

    private String inputParam;

    private String outputParam;

    private String relationUuid;

}
