package com.example.demoSpringBoot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // cấu hình nếu chỗ nào có link tới 1 file CSS thì sẽ trỏ tới file /WEB-INF/static/css/
        registry.addResourceHandler("/css/**").addResourceLocations("/WEB-INF/static/css/");
    }
}
