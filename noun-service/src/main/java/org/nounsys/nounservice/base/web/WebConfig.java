package org.nounsys.nounservice.base.web;

import org.nounsys.nounservice.base.interceptor.TokenInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author:gaoxu
 * @create:2020-03-17 16:21
 **/
@Configuration
public class WebConfig implements WebMvcConfigurer {
//    @Autowired
//    private TokenInterceptor tokenInterceptor;
//
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(tokenInterceptor)
//                .addPathPatterns("/**")
//                .excludePathPatterns("/swagger-resources/**", "/webjars/**", "/v2/**", "/swagger-ui.html/**");
//    }
}
