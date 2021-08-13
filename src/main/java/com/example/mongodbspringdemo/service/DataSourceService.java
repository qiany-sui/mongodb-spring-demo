package com.example.mongodbspringdemo.service;

import com.alibaba.fastjson.JSON;
import com.example.mongodbspringdemo.bean.entity.DataSource;
import com.example.mongodbspringdemo.bean.vo.datasource.DbConnectionDetail;
import com.example.mongodbspringdemo.bean.vo.datasource.DbConnectionPage;
import com.example.mongodbspringdemo.dao.DataSourceJpaDao;
import org.springframework.beans.BeanUtils;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.LookupOperation;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author qianyuqi
 * @create 2021-08-13 10:06
 */
@Service
public class DataSourceService {

    @Resource
    private DataSourceJpaDao dataSourceJpaDao;

    @Resource
    private MongoTemplate mongoTemplate;

    public DbConnectionDetail getOne(String id) {
        LookupOperation lookupOperation = LookupOperation.newLookup().from("source")   //从表名
                .localField("dbUuid")   //主表关联字段
                .foreignField("relationUuid")   //从表关联字段
                .as("dbStateList");   //查询结果名

        //匹配id条件
        MatchOperation matchOperation = new MatchOperation(Criteria.where("dbUuid").is(id));

        //按回帖时间排序
//        SortOperation sortOperation = new SortOperation(Sort.by(Sort.Order.desc("leaveMessageTime")));
        Aggregation aggregation = Aggregation.newAggregation(matchOperation, lookupOperation);
        List<Map> result = mongoTemplate.aggregate(aggregation, "dataSource", Map.class).getMappedResults();
        List<DbConnectionDetail> collect = result.stream()
                .map(n -> {
                    DataSource dataSource = JSON.parseObject(JSON.toJSONString(n), DataSource.class);
                    DbConnectionDetail dbConnectionDetail = new DbConnectionDetail();
                    BeanUtils.copyProperties(dataSource, dbConnectionDetail);
                    dbConnectionDetail.setDbConnectUuid(id);
                    dbConnectionDetail.setDbTypeStr(getDbTypeStr(dataSource.getDbType()));
                    dbConnectionDetail.setCreateTime(dataSource.getCreateTime().toString());
                    dbConnectionDetail.setUpdateTime(dataSource.getUpdateTime().toString());

                    List<Object> dbStateList = (ArrayList)n.get("dbStateList");
                    if (CollectionUtils.isEmpty(dbStateList)) {
                        dbConnectionDetail.setDbState("0");
                        dbConnectionDetail.setDbStateStr("未应用");
                    } else {
                        dbConnectionDetail.setDbState("1");
                        dbConnectionDetail.setDbStateStr("已应用");
                    }
                    return dbConnectionDetail;
                }).collect(Collectors.toList());


        return collect.get(0);
    }

    private String getDbTypeStr(String dbType) {
        if (dbType == null) {
            return "";
        }
        String dbTypeStr;
        if ("0".equals(dbType)) {
            dbTypeStr = "oracle";
        } else if ("1".equals(dbType)) {
            dbTypeStr = "mysql";
        } else {
            dbTypeStr = "未知";
        }
        return dbTypeStr;
    }

    public DbConnectionPage getPage(String dbName, String dbState, Integer page, Integer size) {

        if (dbName == null) {
            dbName = "";
        }
        if (page < 1) {
            page = 1;
        }
        if (size == 0) {
            size = 10;
        }

        Query query = new Query();
        Pattern pattern = Pattern.compile("^.*" + dbName + ".*$", Pattern.CASE_INSENSITIVE);
        query.addCriteria(Criteria.where("dbName").regex(pattern));
        long count = mongoTemplate.count(query, DataSource.class);
        List<DataSource> dataSources = mongoTemplate.find(query.skip((long) (page - 1) * size).limit(size), DataSource.class);
        List<DbConnectionDetail> details = dataSources.stream()
                .map(ds -> new DbConnectionDetail(
                        ds.getDbUuid(), ds.getDbInstance(), ds.getDbName(), ds.getDbType(),
                        getDbTypeStr(ds.getDbType()), ds.getDbIp(), ds.getDbPort(),
                        ds.getAccount(), ds.getPassword(), "0", "未应用", ds.getCreateUser(),
                        ds.getCreateTime().toString(), ds.getUpdateTime().toString())
                ).collect(Collectors.toList());

        return new DbConnectionPage(details, count);
    }

}
