package com.gordondickens.enterprisespring.infrastructure.config;

import com.gordondickens.enterprisespring.infrastructure.config.service.ServiceConfig;
import com.gordondickens.enterprisespring.service.BeansInContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Date: 12/15/12
 *
 * @author Gordon Dickens Dickens
 */
@Configuration
@EnableTransactionManagement
@ComponentScan("com.gordondickens.enterprisespring.db")
@EnableJpaRepositories(basePackages = {"com.gordondickens.enterprisespring.repository"})
@Import(ServiceConfig.class)
public class ApplicationConfig {

    @Bean
    public BeansInContext beansInContext() {
        return new BeansInContext();
    }
}
