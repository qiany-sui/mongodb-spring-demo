//package com.example.mongodbspringdemo.conver;
//
//import org.springframework.core.convert.converter.Converter;
//import org.springframework.data.convert.WritingConverter;
//
//import java.time.LocalDateTime;
//
///**
// * Java -> MongoDB
// * @author qianyuqi
// * @create 2021-08-13 14:05
// */
//@WritingConverter
//public class DateToString implements Converter<LocalDateTime, String> {
//    @Override
//    public String convert(LocalDateTime source) {
//        return source.toString() + 'Z';
//    }
//}
