package com.example.config;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * swagger访问地址：http://ip+端口 /swagger-ui.html
 * swagger配置类
 * 注解说明
 * @Configuration 注解  让spring加载此类
 * @EnableSwagger2 注解  启用swagger
 * @ConditionalOnProperty 注 解控制是否加载当前类(默认：true) 可选
 *
 * @author lishibo
 * @date 2020年4月30日09:53:44
 */

@Configuration
@EnableSwagger2
@ConditionalOnProperty( name = "config.enable.swagger-ui-open" ,  havingValue = "true")
public class SwaggerConfig {

    /**
     *  创建API应用
     * apiInfo() 增加API相关信息
     * 通过select()函数返回一个ApiSelectorBuilder实例,用来控制哪些接口暴露给Swagger来展现，
     * 本例采用指定扫描的包路径来定义指定要建立API的目录。
     */
    @Bean
    public Docket createdRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 创建该API的基本信息（这些基本信息会展现在文档页面中）
     * 访问地址：http://项目实际地址/swagger-ui.html
     * @return
     */
    public ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("测试使用的接口")
                .description("Rest API接口")
                .version("2.x")
                .build();
    }

}
