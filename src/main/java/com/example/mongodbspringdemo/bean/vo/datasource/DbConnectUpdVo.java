package com.example.mongodbspringdemo.bean.vo.datasource;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @author jiwei.kang
 * @date 2021/3/11
 */
@EqualsAndHashCode(callSuper = true)
@Slf4j
@ApiModel("数据库连接修改Vo类")
@Data
public class DbConnectUpdVo extends DbConnectBaseVo {

    @ApiModelProperty(value = "数据库连接UUID", dataType = "String", required = true)
    @Size(max = 50, message = "数据库连接UUID最长为50个字符")
    @NotBlank(message = "数据库连接UUID不可以为空")
    private String dbConnectUuid;

}
