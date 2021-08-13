package com.example.mongodbspringdemo.bean.vo.datasource;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author qianyuqi
 * @create 2021-07-20 10:14
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DbConnectionDetail {
    // 数据库连接的UUID唯一标识
    private String dbConnectUuid;
    // 数据库实例
    private String dbInstance;
    // 数据库连接名称
    private String dbName;
    // 数据库类型 0:oracle 1:mysql
    private String dbType;
    // 数据库类型字符串
    private String dbTypeStr;
    // 数据库IP
    private String dbIp;
    // 数据库端口
    private String dbPort;
    // 数据库账号
    private String account;
    // 数据库密码
    private String password;
    // 据库连接关联状态 0未应用 1已应用
    private String dbState;
    // 数据库连接关联状态字符串
    private String dbStateStr;
    // 创建者
    private String createUser;
    // 创建时间
    private String createTime;
    // 修改时间
    private String updateTime;

}
