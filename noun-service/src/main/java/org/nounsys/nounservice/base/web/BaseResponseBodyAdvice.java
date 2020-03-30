package org.nounsys.nounservice.base.web;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.xml.ws.Response;
import java.text.SimpleDateFormat;


/**
 * @author:gaoxu
 * @create:2020-03-23 10:21
 **/
@ControllerAdvice(basePackages = "org.nounsys.nounservice.access.controller")
public class BaseResponseBodyAdvice implements ResponseBodyAdvice {

    private static Logger logger = LoggerFactory.getLogger(BaseResponseBodyAdvice.class);

    private static final ObjectMapper objectMapper;

    static {
        objectMapper = new ObjectMapper();
        objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
    }

    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter methodParameter, MediaType mediaType, Class aClass,
                                  ServerHttpRequest request, ServerHttpResponse response) {
        Object wrapperBody = body;
        try {
            if (!(body instanceof Response)) {
                if (body instanceof String) {
                    wrapperBody = objectMapper.writeValueAsString(ResultUtil.creObjSucResult(body));
                } else {
                    wrapperBody = ResultUtil.creObjSucResult(body);
                }
            }
        } catch (Exception e) {
            logger.error("request uri path: {}, format response body error", request.getURI().getPath(), e);
        }
        return wrapperBody;
    }
}
