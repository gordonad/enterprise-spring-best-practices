package com.gordondickens.enterprisespring.infrastructure.config.web;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.gordondickens.enterprisespring.web",
        useDefaultFilters = false,
        includeFilters = {@ComponentScan.Filter(
                value = Controller.class,
                type = FilterType.ANNOTATION)})
public class RestWebServiceConfig extends WebMvcConfigurerAdapter {

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable("demo");
    }

    /**
     * Content Negotiation (old CNVR)
     * PathExtension allows URL to add ".type" where type is in the map to path for type by request
     *
     * @param configurer Content Negotiating Configurer
     */
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        Map<String, MediaType> mediaTypes = new HashMap<String, MediaType>();
        mediaTypes.put("json", MediaType.APPLICATION_JSON);
        mediaTypes.put("xml", MediaType.APPLICATION_XML);
        mediaTypes.put("rss", MediaType.APPLICATION_ATOM_XML);

        configurer.favorPathExtension(true).mediaTypes(mediaTypes).defaultContentType(MediaType.APPLICATION_JSON);
    }
}
