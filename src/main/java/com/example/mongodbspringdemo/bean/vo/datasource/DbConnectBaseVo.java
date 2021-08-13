package com.example.mongodbspringdemo.bean.vo.datasource;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @author qianyuqi
 * @create 2021-07-09 17:48
 */
@Data
public class DbConnectBaseVo {

    @ApiModelProperty(value = "数据库实例", dataType = "String", required = true)
    @Size(max = 20, message = "数据库实例最长为20个字符")
    protected String dbInstance;

    @ApiModelProperty(value = "数据库连接名称", dataType = "String", required = true)
    @Size(max = 20, message = "数据库连接最长为20个字符")
    @NotBlank(message = "数据库连接名称不可以为空")
    protected String dbName;

    @ApiModelProperty(value = "数据库类型: 0, oracle, 1,mysql", dataType = "String", required = true)
    @Size(max = 10, message = "数据库类型最长为10个字符")
    @NotBlank(message = "数据库类型不可以为空")
    protected String dbType;

    @ApiModelProperty(value = "数据库IP", dataType = "String", required = true)
    @Size(max = 20, message = "数据库IP最长为20个字符")
    protected String dbIp;

    @ApiModelProperty(value = "数据库端口", dataType = "String", required = true)
    @Size(max = 10, message = "数据库端口最长为10个字符")
    @NotBlank(message = "数据库端口不可以为空")
    protected String dbPort;

    @ApiModelProperty(value = "数据库账号", dataType = "String", required = true)
    @Size(max = 20, message = "数据库账号最长为20个字符")
    @NotBlank(message = "数据库不可以为空")
    protected String account;

    @ApiModelProperty(value = "数据库密码", dataType = "String", required = true)
    @Size(max = 20, message = "数据库密码长度最长为20个字符")
    @NotBlank(message = "数据库密码不可以为空")
    protected String password;
}
