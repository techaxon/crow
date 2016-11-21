package com.name.crow.config;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

/**
 * Created by pchandramohan on 11/20/16.
 */
@Configuration
//@ComponentScan(basePackageClasses = Application.class, excludeFilters = @ComponentScan.Filter({Controller.class, Configuration.class}))
@ComponentScan(basePackages = "com.name.crow")
public class ApplicationConfig {

    @Bean
    public static PropertyPlaceholderConfigurer propertyPlaceholderConfigurer() {
        PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
        ppc.setLocation(new ClassPathResource("/dbconfig.properties"));
        return ppc;
    }

}