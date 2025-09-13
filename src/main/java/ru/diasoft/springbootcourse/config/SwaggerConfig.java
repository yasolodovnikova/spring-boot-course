package ru.diasoft.springbootcourse.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Конфигурация Swagger для автоматической генерации документации API.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     * Бин для настройки Swagger Docket.
     *
     * @return конфигурация {@link Docket}
     */
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("ru.diasoft.springbootcourse.controller"))
                .paths(PathSelectors.any())
                .build();
    }
}
