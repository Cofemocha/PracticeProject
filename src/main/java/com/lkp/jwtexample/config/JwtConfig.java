package com.lkp.jwtexample.config;

import com.lkp.jwtexample.interceptor.JwtInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class JwtConfig  implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new JwtInterceptor()).addPathPatterns("/user/**").excludePathPatterns("/user/login","/user/loginout");
    }
}
