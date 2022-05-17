package com.magusabdul.miniprojectspringboot.swagger;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
    
    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
        .select()
        .apis(RequestHandlerSelectors.any())
        .paths(PathSelectors.any())
        .build()
        .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo(){
        ApiInfo apiInfo = new ApiInfo(
            "My Demo Api", 
            "Ini Adalah demo API dengan Springboot", 
            "v1.0", 
            "Terms Of Service", 
            new Contact("Agus Abdul Malik", "www.malikagus.blogspot.com", "magusabdul@gmail.com"), 
            "Apache License", 
            "www.apache.com", 
            Collections.emptyList()
            );
        return apiInfo;
    }
}