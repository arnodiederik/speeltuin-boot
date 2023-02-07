package org.speeltuin.speeltuindata.app.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    public static final String HTTP_200 = "Successful operation";
    public static final String HTTP_204 = "No Content";
    public static final String HTTP_400 = "Bad request, illegal arguments";
    public static final String HTTP_401 = "Unauthorized";
    public static final String HTTP_403 = "Forbidden";
    public static final String HTTP_404 = "Not found";
    public static final String HTTP_500 = "Internal server error";

    @Value("1.0")
    private String buildVersion;

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("org.speeltuin.speeltuindata"))
                .build()
                .useDefaultResponseMessages(false)
                .apiInfo(apiInfo())
                .tags(
                        new Tag("Data", "data beheer")
                );
//                .securityContexts(Collections.singletonList(actuatorSecurityContext()))
//                .securitySchemes(Collections.singletonList(basicAuthScheme()));
    }

    private ApiInfo apiInfo() {

        return new ApiInfo("Speeltuin data",
                "API speeltuin data services.",
                buildVersion,
                null,
                null,
                null,
                null,
                Collections.emptyList());
    }

//    private SecurityContext actuatorSecurityContext() {
//        return SecurityContext.builder()
//                .securityReferences(Collections.singletonList(basicAuthReference()))
//                .forPaths(PathSelectors.ant("/api/**"))
//                .build();
//    }

//    private SecurityScheme basicAuthScheme() {
//        return new BasicAuth("basicAuth");
//    }

//    private SecurityReference basicAuthReference() {
//        return new SecurityReference("basicAuth", new AuthorizationScope[0]);
//    }

}

