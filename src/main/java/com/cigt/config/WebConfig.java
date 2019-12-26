package com.cigt.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 拦截器
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
//    @Autowired
//    private SessionInterceptor sessionInterceptor;
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(sessionInterceptor).addPathPatterns("/**")
//                .excludePathPatterns("/","/error","/static/**","/login","/register","/loginInfo","/index");
//    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //映射图片保存地址
        registry.addResourceHandler("/images/**").addResourceLocations("file:C:/Users/Administrator/Desktop/CIGTimages");
    }
}
