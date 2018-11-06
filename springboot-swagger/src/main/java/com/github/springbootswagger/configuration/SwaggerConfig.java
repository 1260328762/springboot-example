package com.github.springbootswagger.configuration;

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


/**
 * Swagger配置类
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //要生成api的控制器路径
                .apis(RequestHandlerSelectors.basePackage("com.github.springbootswagger.web"))
                //设置要忽略哪些请求
                .paths(PathSelectors.any())
                .build();
    }



    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("springboot整合swagger测试")
                .description("文档的描述")
                .version("0.0.0")
                .contact(new Contact("chenliang", "", ""))
                .termsOfServiceUrl("www.baidu.com")
                .build();
    }

}
