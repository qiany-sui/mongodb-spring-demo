package com.example.mongodbspringdemo.bean.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 计算单元与源关系表
 *
 * @date 2019-12-21 17:06:43
 */
@Data
public class UnitSource implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 计算单元数据源uuid
     */
    private String unitSourceUuid;
    /**
     * 计算单元
     */
    private String unitUuid;
    /**
     * 0- 配置,1- python录入,2- x代码,3-ERP
     */
    private String unitType;
    /**
     * 源名称
     */
    private String sourceName;
    /**
     * 数据来源： 000-api，100-数据库,200-Excel,300-分布式
     */
    private String sourceType;
    /**
     * excel 列解析mapping表ID
     */
    private String sourceUuid;
    /**
     * JSON 示例 ID
     */
    private String apiId;
    /**
     * 数据库库名
     */
    private String dbName;
    /**
     * 数据库表名/erp表名
     */
    private String dbTable;
    /**
     * 项目名称
     */
    private String projName;
    /**
     * excel版本/erp数据版本
     */
    private String version;
    /**
     * key-api-json
     */
    private String keySource;
    /**
     * key-hited/key-jsonpath
     */
    private String keyValue;
    /**
     * 计算值来源
     */
    private String valueRelevant;
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
