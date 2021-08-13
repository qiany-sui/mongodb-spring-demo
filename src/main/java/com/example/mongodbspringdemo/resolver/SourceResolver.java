package com.example.mongodbspringdemo.resolver;

import com.example.mongodbspringdemo.bean.vo.source.SourceInfo;
import com.example.mongodbspringdemo.service.SourceService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author qianyuqi
 * @create 2021-08-13 13:36
 */
@Component
public class SourceResolver implements GraphQLQueryResolver {

    private final SourceService sourceService;
    public SourceResolver(SourceService sourceService) {
        this.sourceService = sourceService;
    }

    public List<SourceInfo> listSources() {
        return sourceService.getAll();
    }

}
