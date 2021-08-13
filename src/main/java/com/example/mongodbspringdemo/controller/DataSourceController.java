package com.example.mongodbspringdemo.controller;

import com.example.mongodbspringdemo.bean.demo.PersonJpa;
import com.example.mongodbspringdemo.bean.entity.DataSource;
import com.example.mongodbspringdemo.bean.vo.datasource.DbConnectAddVo;
import com.example.mongodbspringdemo.bean.vo.datasource.DbConnectDelVo;
import com.example.mongodbspringdemo.bean.vo.datasource.DbConnectUpdVo;
import com.example.mongodbspringdemo.dao.DataSourceJpaDao;
import com.example.mongodbspringdemo.dao.PersonJpaDao;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.core.query.UntypedExampleMatcher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Optional;

/**
 * @author qianyuqi
 * @create 2021-08-13 10:10
 */
@RestController
@RequestMapping("jpa/datasource")
public class DataSourceController {

    @Resource
    private DataSourceJpaDao dataSourceJpaDao;

    // 增加数据
    @PostMapping("/insert")
    public ResponseEntity<String> insert(@RequestBody DbConnectAddVo addVo) {
        DataSource dataSource = addVo.cloneNewDataSource();
        DataSource save = dataSourceJpaDao.save(dataSource);
        return ResponseEntity.ok("添加成功,添加后的dbUuid为：" + save.getDbUuid());
    }

    // 修改数据
    @PostMapping("update")
    public ResponseEntity<String> update(@RequestBody DbConnectUpdVo updVo) {

        DataSource findDSQuery = new DataSource();
        findDSQuery.setDbUuid(updVo.getDbConnectUuid());
        Example<DataSource> of = Example.of(findDSQuery, UntypedExampleMatcher.matchingAny());
        Optional<DataSource> findOne = dataSourceJpaDao.findOne(of);
        if(!findOne.isPresent()) {
            return ResponseEntity.ok("修改失败,当前的 【" + updVo.getDbName() + "】 不存在！");
        }
        DataSource dataSource = findOne.get();
//        BeanUtils.copyProperties(updVo, dataSource);
        dataSource.setDbName(updVo.getDbName());
        dataSource.setUpdateTime(LocalDateTime.now());
        dataSource.setDbType(updVo.getDbType());
        dataSource.setDbPort(updVo.getDbPort());
        dataSourceJpaDao.save(dataSource);
        return ResponseEntity.ok("修改成功,修改数量：1");
    }

    // 删除数据
    @PostMapping("/delete")
    public ResponseEntity<String> delete(@RequestBody DbConnectDelVo delVo) {
        DataSource findDSQuery = new DataSource();
        findDSQuery.setDbUuid(delVo.getDbConnectUuid());
        Example<DataSource> of = Example.of(findDSQuery, UntypedExampleMatcher.matchingAny());
        Optional<DataSource> findOne = dataSourceJpaDao.findOne(of);
        if(!findOne.isPresent()) {
            return ResponseEntity.ok("删除成功,当前需要删除的id不存在：" + delVo.getDbConnectUuid());
        }
        DataSource dataSource = findOne.get();
        dataSourceJpaDao.delete(dataSource);
        return ResponseEntity.ok("删除成功,删除的数据为：" + dataSource);
    }
}
