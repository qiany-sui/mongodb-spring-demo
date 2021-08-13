package com.example.mongodbspringdemo.bean.entity;

import com.alibaba.fastjson.JSONArray;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Date;

/**
 * 指标表
 *
 * @date 2019-12-21 17:06:42
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Index implements Serializable {

    /**
     * 指标 uuid
     */
    private String indexUuid;
    /**
     * 指标名称
     */
    private String indexName;
    /**
     * 指标英文名
     */
    private String indexCode;
    /**
     * 版本
     */
    private String indexVersion;
    /**
     * 指标计算所有单元
     */
    private JSONArray indexUnits;
    /**
     * 计算单元类型 0-非EREP 。1-ERP
     */
    private String unitType;
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

    private String indexUnitsStr;
}
