package com.example.mongodbspringdemo.controller;

import com.alibaba.fastjson.JSON;
import com.example.mongodbspringdemo.bean.entity.DataSource;
import com.example.mongodbspringdemo.bean.entity.Source;
import com.example.mongodbspringdemo.bean.vo.datasource.DbConnectAddVo;
import com.example.mongodbspringdemo.bean.vo.source.AddDataSourceBean;
import com.example.mongodbspringdemo.dao.DataSourceJpaDao;
import com.example.mongodbspringdemo.dao.SourceJpaDao;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

/**
 * @author qianyuqi
 * @create 2021-08-13 09:30
 */
@RestController
@RequestMapping("jpa/source")
public class SourceController {

    @Resource
    private SourceJpaDao sourceJpaDao;

    @Resource
    private DataSourceJpaDao dataSourceJpaDao;

    // 增加数据
    @PostMapping("/insert")
    public ResponseEntity<String> insert(@RequestBody AddDataSourceBean addVo) {

        Optional<DataSource> findOne = dataSourceJpaDao.findById(addVo.getDbConnectUuid());
        if(!findOne.isPresent()) {
            return ResponseEntity.ok("添加失败,无法找到dbConnectUuid：" + addVo.getDbConnectUuid());
        }
        DataSource source = findOne.get();
        addVo.setCreateUser("xiaomai");
        addVo.setNameSpace(addVo.getQuerySql());
        addVo.setSchemaName(source.getDbName());

        String uuId = UUID.randomUUID().toString();
        Source sourceData = new Source();
        BeanUtils.copyProperties(addVo, sourceData);

        sourceData.setDcId(uuId);
        sourceData.setSourceUuid(uuId);//数据源 uuid
        sourceData.setUpdateUser(addVo.getCreateUser());//更新者
        sourceData.setCreateTime(LocalDateTime.now());//数据源创建日期
        sourceData.setDatachangeLasttime(LocalDateTime.now());//更新时间
        sourceData.setVersion("V1.0.0");//api/excel版本号/数据库版本号
        sourceData.setNameSpace(addVo.getNameSpace());
        sourceData.setInputParam(JSON.toJSONString(addVo.getInputParams()));
        sourceData.setOutputParam(addVo.getOutputParams());
        sourceData.setRelationUuid(addVo.getDbConnectUuid());
        Source save = sourceJpaDao.save(sourceData);
        return ResponseEntity.ok("添加成功,添加后的id为：" + save.getDcId());
    }
}
