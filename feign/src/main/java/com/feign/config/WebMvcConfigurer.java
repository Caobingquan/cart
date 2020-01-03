package com.feign.config;

import com.feign.interceptor.AuthenticationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

/**
 * @author {曹炳全}
 * @Title WebMvcConfigurer
 * @Description
 * @date 2019/12/23 14:19
 */
@Configuration
public class WebMvcConfigurer implements org.springframework.web.servlet.config.annotation.WebMvcConfigurer {
    @Bean
    public AuthenticationInterceptor myInterceptor(){
        return new AuthenticationInterceptor();
    }
    /**
     *配置拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myInterceptor()).addPathPatterns("/**");

    }

}
