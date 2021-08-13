package com.example.mongodbspringdemo.dao;

import com.example.mongodbspringdemo.bean.demo.PersonJpa;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author qianyuqi
 * @create 2021-08-13 09:37
 */
@Repository
public interface PersonJpaDao extends MongoRepository<PersonJpa, String> {
    PersonJpa findByName(String name);//自定义查询方法查询单个数据
}
