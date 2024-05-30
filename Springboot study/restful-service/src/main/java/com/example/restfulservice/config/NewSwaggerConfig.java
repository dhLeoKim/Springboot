package com.example.restfulservice.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(
                title = "Restful-Service API 명세서",
                description = "SpringBoot로 개발한 API 명세서",
                version = "v1.0.0"
                )
)
@Configuration
@RequiredArgsConstructor
public class NewSwaggerConfig {

    @Bean
    public GroupedOpenApi customTestOpenAPI() {
        String[] paths = {"/users/**", "admin/**"};

        return GroupedOpenApi.builder()
                .group("일반 사용자와 관리자를 위한 API")
                .pathsToMatch(paths)
                .build();
    }
}
