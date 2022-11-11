package com.tencent.wxcloudrun.config;

import com.tencent.wxcloudrun.interceptor.InInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 无语
 * @create 2022-11-11 10:48
 */
public class MyMVCConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new InInterceptor())
        .addPathPatterns("/api/put")
        .excludePathPatterns("/","/*.html","/api/count");
    }
}
