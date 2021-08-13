//package com.example.mongodbspringdemo.config;
//
//import com.mongodb.client.MongoClients;
//import lombok.Data;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.data.mongodb.core.SimpleMongoClientDbFactory;
//import org.springframework.stereotype.Component;
//
///**
// * @author qianyuqi
// * @create 2021-08-12 19:41
// */
//@Component
//@ConfigurationProperties("mongodb")
//@Data
//public class MongoDBConfig {
//    private String url;
//    private String database;
//
//    @Bean
//    public MongoTemplate mongoTemplate() {
//        return new MongoTemplate(new )
//
//        return new MongoTemplate(new SimpleMongoClientDbFactory(MongoClients.create(url), database));
//    }
//}
