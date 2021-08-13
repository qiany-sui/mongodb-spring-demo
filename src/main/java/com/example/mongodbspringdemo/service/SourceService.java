package com.example.mongodbspringdemo.service;

import com.example.mongodbspringdemo.bean.entity.Source;
import com.example.mongodbspringdemo.bean.vo.source.SourceInfo;
import com.example.mongodbspringdemo.dao.SourceJpaDao;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author qianyuqi
 * @create 2021-08-13 09:30
 */
@Service
public class SourceService {

    @Resource
    private SourceJpaDao sourceJpaDao;

    public List<SourceInfo> getAll() {
        List<Source> all = sourceJpaDao.findAll();
        return all.stream()
                .map(n -> {
                    SourceInfo sourceInfo = new SourceInfo();
                    BeanUtils.copyProperties(n, sourceInfo);
                    sourceInfo.setCreateTime(n.getCreateTime().toString());
                    sourceInfo.setDatachangeLasttime(n.getDatachangeLasttime().toString());
                    return sourceInfo;
                }).collect(Collectors.toList());
    }
}
