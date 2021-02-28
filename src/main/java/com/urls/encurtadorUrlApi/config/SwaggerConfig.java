package com.urls.encurtadorUrlApi.config;

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
 *
 * @author Marcus
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    
    @Bean
    public Docket productApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.urls.encurtadorUrlApi"))
                .paths(PathSelectors.regex("/api.*"))
                .build()
                .apiInfo(metaInfo());                
    }
    
    private ApiInfo metaInfo() {
        ApiInfo apiInfo1 = new ApiInfoBuilder()
            .title("Encurtador de URL's API Rest")
            .description("Back-end para o projeto Encurtador de URL")
            .version("1.0.0")
            .license("Apache License Version 2.0")
            .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0\"")
            .contact(new Contact("Marcus Carvalho", "https://github.com/marcuscarvalho1", "marcuscarvalho1@yahoo.com.br"))
            .build();
        
        return apiInfo1;
    }     
}
