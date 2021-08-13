package com.example.mongodbspringdemo.utils;

import java.util.UUID;

/**
 * @author qianyuqi
 * @create 2021-08-13 10:48
 */
public class GenerateUuidUtil {
    private GenerateUuidUtil() {
    }

    public static String generateUuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
