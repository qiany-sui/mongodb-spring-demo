//package com.example.mongodbspringdemo.conver;
//
//import org.springframework.core.convert.converter.Converter;
//import org.springframework.data.convert.ReadingConverter;
//
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//
///**
// * MongoDB -> Java
// * @author qianyuqi
// * @create 2021-08-13 14:07
// */
//@ReadingConverter
//public class StringToDate implements Converter<String, LocalDateTime> {
//    @Override
//    public LocalDateTime convert(String source) {
//        return LocalDateTime.parse(source, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"));
//    }
//}
