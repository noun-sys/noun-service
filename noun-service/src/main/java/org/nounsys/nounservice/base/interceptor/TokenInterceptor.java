package org.nounsys.nounservice.base.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.nounsys.nounservice.base.exception.BusinessException;
import org.nounsys.nounservice.base.exception.ErrorCodeEnum;
import org.nounsys.nounservice.base.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author:gaoxu
 * @create:2020-03-17 16:07
 **/
@Component
@Slf4j
public class TokenInterceptor extends HandlerInterceptorAdapter {

    private static String TOKEN = "token";

    @Autowired
    private JwtUtils jwtUtils;

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        // 地址过滤
        String uri = request.getRequestURI();
        if (uri.contains("/user/token")) {
            return true;
        }
        // Token 校验
        String token = request.getHeader(TOKEN);
        if (StringUtils.isEmpty(token)) {
            log.error("token不能为空,header:{}");
            throw new BusinessException(ErrorCodeEnum.SERVER_COMMON_ERROR);
        }
        // Token 有效性校验
        if (jwtUtils.verify(token)) {
            return true;
        } else {
            log.error("token不能为空,header:{}");
            throw new BusinessException(ErrorCodeEnum.SERVER_COMMON_ERROR);
        }
    }
}
