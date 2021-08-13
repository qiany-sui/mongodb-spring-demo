package com.example.mongodbspringdemo.bean.vo.datasource;

import com.example.mongodbspringdemo.bean.entity.DataSource;
import com.example.mongodbspringdemo.utils.GenerateUuidUtil;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;

/**
 * @author jiwei.kang
 * @date 2021/3/11
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("数据库连接信息新增Vo")
public class DbConnectAddVo extends DbConnectBaseVo {

    /**
     * 克隆DataSource类
     */
    public DataSource cloneNewDataSource() {
        DataSource dataSource = new DataSource();
        String uuid = GenerateUuidUtil.generateUuid();
        BeanUtils.copyProperties(this, dataSource);
        dataSource.setDcId(uuid);
        dataSource.setDbUuid(uuid);
        dataSource.setDbType(this.getDbType() + "");
        dataSource.setDbPort(this.getDbPort() + "");
        dataSource.setIsDelete("0");
        dataSource.setCreateTime(LocalDateTime.now());
        dataSource.setUpdateTime(LocalDateTime.now());
        dataSource.setCreateUser("xiaomai");
        dataSource.setCustom("ICBC");
        return dataSource;
    }

}
