package org.nounsys.nounservice.base.web;

import org.nounsys.nounservice.base.aspect.CustomRequestMappingHandlerMapping;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 * @author:gaoxu
 * @create:2020-03-27 11:24
 **/
@Configuration
public class ApiConfig extends WebMvcConfigurationSupport {
    @Override
    @Bean
    public RequestMappingHandlerMapping createRequestMappingHandlerMapping() {
        RequestMappingHandlerMapping handlerMapping = new CustomRequestMappingHandlerMapping();
        return handlerMapping;
    }
}
