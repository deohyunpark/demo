package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.OAS_30)
                .useDefaultResponseMessages(false) // Swagger 에서 제공해주는 기본 응답 코드를 표시할 것이면 true
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.demo.controller")) // Controller가 들어있는 패키지. 이 경로의 하위에 있는 api만 표시됨.
                .paths(PathSelectors.any()) // 위 패키지 안의 api 중 지정된 path만 보여줌. (any()로 설정 시 모든 api가 보여짐)
                .build();
    }

    private Set<String> getConsumeContentTypes() {
        Set<String> consumes = new HashSet<>();
        consumes.add("application/json;charset=UTF-8");
        return consumes;
    }

    private Set<String> getProduceContentTypes() {
        Set<String> produces = new HashSet<>();
        produces.add("application/json;charset=UTF-8");
        return produces;
    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Demo Spring Boot Project")
                .version("1.0.0")
                .description("사전과제 프로젝트 API 문서화 위한 Swagger API")
                .build();
    }
}
