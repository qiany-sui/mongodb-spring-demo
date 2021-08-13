package com.example.mongodbspringdemo.resolver;

import com.example.mongodbspringdemo.bean.vo.datasource.DbConnectionDetail;
import com.example.mongodbspringdemo.bean.vo.datasource.DbConnectionPage;
import com.example.mongodbspringdemo.service.DataSourceService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author qianyuqi
 * @create 2021-08-13 13:36
 */
@Component
public class DataSourceResolver implements GraphQLQueryResolver {

    @Resource
    private DataSourceService dataSourceService;
//    private final DataSourceService dataSourceService;
//    public DataSourceResolver(DataSourceService dataSourceService) {
//        this.dataSourceService = dataSourceService;
//    }

    public DbConnectionDetail detailDbConnectionByUuid(String dbConnectUuid) {
        return dataSourceService.getOne(dbConnectUuid);
    }

    public DbConnectionPage listPageDbConnections(String dbName, String dbState, Integer page, Integer size) {
        return dataSourceService.getPage(dbName, dbState, page, size);
    }


}
