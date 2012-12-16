package com.gordondickens.enterprisespring.infrastructure.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
public class RestWebServiceTestConfig extends WebMvcConfigurerAdapter {

    /**
     * Content Negotiation (old CNVR)
     * @param configurer Content Negotiation Configurer
     */
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.favorPathExtension(true).favorParameter(true);
    }
}
