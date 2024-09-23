package com.example.finalprojectinterpol.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/admin").setViewName("admin");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/news/create").setViewName("newsCreate");
        registry.addViewController("/news/all").setViewName("newsViewAll");
        registry.addViewController("/statement/create").setViewName("statementCreate");
        registry.addViewController("/statement/all").setViewName("statementViewAll");
        registry.addViewController("/statement/update").setViewName("statementUpdate");
        registry.addViewController("/registration").setViewName("registration");
    }

//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/")
//                .addResourceLocations("/images", "classpath:/static/")
//                .setCachePeriod(31556926);
//    }
}
