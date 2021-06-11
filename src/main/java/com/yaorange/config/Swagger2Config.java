package com.yaorange.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())//创建api文档的基本信息
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.yaorange"))//指定扫描生成api的包(一般需要扫描同时实体和Controller)
                .paths(PathSelectors.any())//指定那些请求路径加入api文档
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring Boot中使用Swagger2构建RESTful APIs")//设置文档的标题
                .description("雅橙科技")// 设置文档的描述
                .version("1.0")// 设置文档的描述
                .build();
    }
}
