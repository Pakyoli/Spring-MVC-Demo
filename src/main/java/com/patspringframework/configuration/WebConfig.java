package com.patspringframework.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

/**
 * Created by pakyo_000 on 6/6/2016.
 */
@Configuration
@EnableWebMvc
@ComponentScan({"com.patspringframework.*"})
@Import({SecurityConfig.class})
public class WebConfig extends WebMvcConfigurerAdapter {

    @Autowired
    Environment environment;

    @Bean(name = "dataSource")
    public DriverManagerDataSource dataSource(){

        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
        driverManagerDataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
        driverManagerDataSource.setUsername(environment.getRequiredProperty("jdbc.username"));
        driverManagerDataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
        return driverManagerDataSource;
    }

}
