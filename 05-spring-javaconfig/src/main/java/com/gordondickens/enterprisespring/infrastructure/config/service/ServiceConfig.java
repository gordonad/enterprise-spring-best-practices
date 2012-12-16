package com.gordondickens.enterprisespring.infrastructure.config.service;

import com.gordondickens.enterprisespring.service.ItemService;
import com.gordondickens.enterprisespring.service.internal.ItemServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * enterprise-spring-parent
 * <p/>
 * Date: 12/15/12
 * <p/>
 *
 * @author Gordon Dickens
 */
@Configuration
public class ServiceConfig {

    @Bean
    public ItemService itemService() {
        return new ItemServiceImpl();
    }
}
