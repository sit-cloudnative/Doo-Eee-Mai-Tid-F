package com.sit.cloudnative.VideoHistoryService.Config;

import com.sit.cloudnative.VideoHistoryService.Interceptor.TokenInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.MappedInterceptor;

@Configuration
public class TokenInterceptorConfig implements WebMvcConfigurer {
    @Value("${jwt.secret}")
    private String JWT_SECRET;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(tokenInterceptor());
    }

    @Bean
    public MappedInterceptor tokenInterceptor() {
        return new MappedInterceptor(
                new String[] {"**", ""},
                new TokenInterceptor(JWT_SECRET));
    }
}
