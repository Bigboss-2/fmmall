package com.qfedu.fmmall.config;


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
public class SwaggerConfig {

    /**Swagger会帮助我们生成接口文档
     * 1：配置生成的文档信息
     * 2：配置生成规则*/

    /*
    Docket封装接口文档信息
     */
    @Bean
    public Docket getDocket(){


        //创建封面信息对象
        ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();
        apiInfoBuilder.title("《锋迷商城》后端接口说明")
                        .description("此文档详细说明了锋迷商城项目后端接口规范....")
                                .version("v 2.0.1")
                                        .contact(new Contact("高宏达","www.gouda0305.cn","gaohda0305@163.com"));
        ApiInfo apiInfo = apiInfoBuilder.build();

        Docket docket = new Docket(DocumentationType.SWAGGER_2)   //指定文档风格
                .apiInfo(apiInfo)   //指定生成的文档中的封面信息：文档标题、版本、作者
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.qfedu.fmmall.controller"))
                .paths(PathSelectors.any())
                .build();

        return docket;
    }

}
