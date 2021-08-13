package com.example.mongodbspringdemo.dao;

import com.example.mongodbspringdemo.bean.entity.DataSource;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author qianyuqi
 * @create 2021-08-13 09:37
 */
@Repository
public interface DataSourceJpaDao extends MongoRepository<DataSource, String> {
}
