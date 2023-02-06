package com.asteroid.duck.sdn.config;

import com.asteroid.duck.sdn.model.Attends;
import com.asteroid.duck.sdn.model.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;


@Configuration
public class WebConfig {
    @Bean
    public RepositoryRestConfigurer corsConfigurer()
    {
        return new RepositoryRestConfigurer() {
            public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors)
            {
                cors.addMapping("/**").allowedMethods("*");
                config.exposeIdsFor(Attends.class, com.asteroid.duck.sdn.model.Class.class, Person.class);
            }
        };
    }
}
