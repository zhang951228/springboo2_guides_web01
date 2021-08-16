package com.erayt.web01.configuration;

import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Auther: Z151
 * @Date: 2021/8/16 18:20
 */

public class MvcConfigurer implements WebMvcConfigurer {
    //拦截器
    public void addInterceptors (InterceptorRegistry registry) {

    }

    // 跨域访问配置
    public void addCorsMappings(CorsRegistry registry) {

    }

    //格式化
    public void addFormatters (FormatterRegistry registry) {

    }

    // URI 到视图的映射
    public void addViewControllers(ViewControllerRegistry registry) {

    }

// 其他更多全局定制接口

}