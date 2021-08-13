package com.example.mongodbspringdemo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Value("${swagger.enabled:true}")
    private Boolean swaggerEnabled;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                //是否开启
                .enable(swaggerEnabled)
                .select()
                //自动扫描包的路径：指的是我们在哪些类中使用swagger2来测试
                .apis(RequestHandlerSelectors.basePackage("com.example.mongodbspringdemo.controller"))
                //指定路径处理。PathSelectors.any() 代表所有的路径。
                .paths(PathSelectors.any()).build().pathMapping("/");
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //页面标题
                .title("Graphql MongoDB API")
                //描述
                .description("使用 Swagger2 生成的接口文档")
                //作者信息
                .contact(new Contact("xuanr", "https://www.xuanr.cn", "123@qq.com"))
                .version("1.0.0")
                .build();
    }
}
