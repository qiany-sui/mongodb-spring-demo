package com.example.mongodbspringdemo.bean.vo.datasource;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author qianyuqi
 * @create 2021-08-13 14:52
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DbConnectionPage {
    private List<DbConnectionDetail> records;
    private long total;
}
