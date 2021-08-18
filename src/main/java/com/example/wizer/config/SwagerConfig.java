//package com.example.wizer.config;
//
//import com.google.common.collect.Lists;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.ResponseEntity;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.service.*;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spi.service.contexts.SecurityContext;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//import java.awt.print.Pageable;
//import java.util.ArrayList;
//import java.util.List;
//
//import static springfox.documentation.builders.PathSelectors.regex;
//
//@EnableSwagger2
//@Configuration
//class SwaggerConfig {
//
//    public static final String AUTHORIZATION_HEADER = "Authorization";
//
//    public static final String DEFAULT_INCLUDE_PATTERN = "/api/.*";
//
//
//    @Bean
//    public Docket swaggerSpringfoxDocket() {
//
//        Contact contact = new Contact(
//                "WIZER ADVISORY", "wizerAdvisory.com", "info@wizerAdvisory.net"
//        );
//
//        List<VendorExtension> vext = new ArrayList<>();
//        ApiInfo apiInfo = new ApiInfo(
//                "WIZER ADVISORY",
//                "This is the best stuff since sliced bread - API",
//                "1.0.0",
//                "wizerAdvisory.com",
//                contact,
//                "07068693731",
//                "wizerAdvisory.com",
//                vext);
//
//        Docket docket = new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo)
//                .pathMapping("/")
//                .apiInfo(ApiInfo.DEFAULT)
//                .forCodeGeneration(true)
//                .genericModelSubstitutes(ResponseEntity.class)
//                .ignoredParameterTypes(Pageable.class)
//                .ignoredParameterTypes(java.sql.Date.class)
////            .directModelSubstitute(java.time.LocalDate.class, java.sql.Date.class)
////            .directModelSubstitute(java.time.ZonedDateTime.class, Date.class)
////            .directModelSubstitute(java.time.LocalDateTime.class, Date.class)
//                .securityContexts(Lists.newArrayList(securityContext()))
//                .securitySchemes(Lists.newArrayList(apiKey()))
//                .useDefaultResponseMessages(false);
//
//        docket = docket.select()
//
//                .build();
//        return docket;
//    }
//
//
//    private ApiKey apiKey() {
//        return new ApiKey("JWT", AUTHORIZATION_HEADER, "header");
//    }
//
//    private SecurityContext securityContext() {
//        return SecurityContext.builder()
//                .securityReferences(defaultAuth())
//                .forPaths(PathSelectors.regex(DEFAULT_INCLUDE_PATTERN))
//                .build();
//    }
//
//    List<SecurityReference> defaultAuth() {
//        AuthorizationScope authorizationScope
//                = new AuthorizationScope("global", "accessEverything");
//        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
//        authorizationScopes[0] = authorizationScope;
//        return Lists.newArrayList(
//                new SecurityReference("JWT", authorizationScopes));
//    }
//}
