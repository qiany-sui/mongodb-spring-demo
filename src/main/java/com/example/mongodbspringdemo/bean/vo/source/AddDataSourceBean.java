package com.example.mongodbspringdemo.bean.vo.source;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * @ClassName: AddDataSourceBean
 * @Description: 新增数据源
 * @Date: 2019/12/23 15:58
 */
@ApiModel(value = "新增数据源")
@Data
public class AddDataSourceBean {

    @ApiModelProperty(value = "数据源名称", dataType = "String", required = true)
    @NotBlank(message = "数据源名称都不可以为空")
    @Size(max = 100, message = "数据源名称最长为100个字符")
    private String sourceName;

    @NotBlank(message = "数据来源类型不可以为空 ")
    @ApiModelProperty(value = "数据来源： 000-api,100-数据库：db,200-Excel：excel,300-分布式", dataType = "String", required = true)
    @Size(max = 100, message = "数据来源类型最长为100个字符")
    private String sourceType;

    @ApiModelProperty(value = "数据来源：001-元素：ele,002-汇法网：law,003-启信宝：qxb,004-发票：fp,301-S3：s3,302-HDFS：hdfs", dataType = "String")
    @Size(max = 100, message = "数据来源最长为100个字符")
    private String subType;

    @ApiModelProperty(value = "JSON 示例 ID,关联 JSON 示例表", dataType = "String")
    @Size(max = 100, message = "API ID最长只能100个字符")
    private String apiId;

    @ApiModelProperty(value = "api/excel版本号/数据库版本号", dataType = "String")
    @Size(max = 100, message = "数据源版本最长为100个字符")
    private String version;

    @ApiModelProperty(value = "数据源地址/路径/excel存储地址", dataType = "String")
    @Size(max = 388, message = "数据源地址最长为388个字符")
    @JsonProperty("sPath")
    private String sPath;

    @ApiModelProperty(value = "账号（凭证号）", dataType = "String")
    @Size(max = 100, message = "账号最长为100个字符")
    private String account;

    @ApiModelProperty(value = "密码（密匙）", dataType = "String")
    @Size(max = 100, message = "密码信息最长为100个字符")
    private String password;

    @ApiModelProperty(value = "驱动", dataType = "String")
    @Size(max = 800, message = "数据库连接地址最长为800个字符")
    private String driver;

    @ApiModelProperty(value = "是否遍历:0-遍历,1-不遍历", dataType = "Byte")
    private Byte isTraversal;

    @ApiModelProperty(value = "数据源描述", dataType = "String")
    @Size(max = 250, message = "数据源描述最长为250个字符")
    private String remark;

    @ApiModelProperty(value = "文件名", dataType = "String")
    private String excelName;

    @ApiModelProperty(value = "列名")
    private List<String> columnName;

    @ApiModelProperty(value = "缓存唯一值", dataType = "String")
    private String uniqueValue;

    @ApiModelProperty(value = "创建者", dataType = "String")
    private String createUser;

    @ApiModelProperty(value = "数据来源名称", dataType = "String")
    private String schemaName;

    @ApiModelProperty(value = "hbase数据库/es索引", dataType = "String")
    @Size(max = 50, message = "数据库/es索引最长只能是50个字符")
    private String nameSpace;

    @ApiModelProperty(value = "列簇", dataType = "String")
    @Size(max = 50, message = "列簇最长为50个字符")
    private String columns;

    @ApiModelProperty(value = "列", dataType = "String")
    @Size(max = 50, message = "列长度最长为50个字符")
    private String field;

    @ApiModelProperty(value = "es索引", dataType = "String")
    @Size(max = 50, message = "es索引长度最长为50个字符")
    private String dbTable;


    @ApiModelProperty(value = "数据库连接的UUID唯一标识", dataType = "String")
    @Size(max = 50, message = "数据库连接标识最长未50个字符")
    private String dbConnectUuid;

    @ApiModelProperty(value = "输入参数(数据库)")
    private List<DBInputParamVO> inputParams;

    @ApiModelProperty(value = "查询SQL", dataType = "String")
    private String querySql;

    @ApiModelProperty(value = "输出字段的json", dataType = "String")
    private String outputParams;

}
