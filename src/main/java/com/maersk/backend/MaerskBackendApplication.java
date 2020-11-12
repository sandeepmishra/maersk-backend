package com.maersk.backend;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableScheduling
public class MaerskBackendApplication {
    public static void main(String[] args) {
        SpringApplication.run(MaerskBackendApplication.class);
    }

    @Bean
    public Docket postsApi(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("maresk-services-api").apiInfo(apiInfo()).select()
                .apis(RequestHandlerSelectors.basePackage("com.maersk.backend.controller")).paths(PathSelectors.any()).build();
    }

    @Bean
    UiConfiguration uiConfiguration(){
        return UiConfigurationBuilder.builder().displayRequestDuration(true).validatorUrl("").build();
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Maresk services API").description("Maresk services api ").version("1.0").build();
    }
}
