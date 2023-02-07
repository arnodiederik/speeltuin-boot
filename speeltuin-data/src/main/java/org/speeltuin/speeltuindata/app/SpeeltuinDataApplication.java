package org.speeltuin.speeltuindata.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableCaching
@EnableJpaRepositories
@SpringBootApplication(scanBasePackages = {"org.speeltuin.speeltuindata"})
public class SpeeltuinDataApplication extends SpringBootServletInitializer {

    // Overriding the configure method from the SpringBootServletInitializer class lets us deploy our application as a WAR in a servlet container in the conventional way.
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpeeltuinDataApplication.class);
    }

    // When the application is run as a JAR, the main method is called.
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplicationBuilder(SpeeltuinDataApplication.class).build();
        springApplication.run(args);
    }

}
