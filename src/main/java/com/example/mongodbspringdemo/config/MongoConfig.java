//package com.example.mongodbspringdemo.config;
//
//import com.example.mongodbspringdemo.conver.DateToString;
//import com.example.mongodbspringdemo.conver.StringToDate;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.convert.converter.Converter;
//import org.springframework.data.mongodb.core.convert.CustomConversions;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @author qianyuqi
// * @create 2021-08-13 14:08
// */
//@Configuration
//public class MongoConfig {
//    @Bean
//    public CustomConversions customConversions() {
//        List<Converter<?, ?>> converterList = new ArrayList<Converter<?, ?>>();
//        converterList.add(new DateToString());
//        converterList.add(new StringToDate());
//        return new CustomConversions(converterList);
//    }
//}
