package com.example.mongodbspringdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
//@EnableMongoRepositories(basePackageClasses = { PersonJpaDao.class }) // springdata的使用
//@EnableMongoRepositories(basePackages = {"com.example.mongodbspringdemo.dao"})
public class MongodbSpringDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MongodbSpringDemoApplication.class, args);
    }

}
