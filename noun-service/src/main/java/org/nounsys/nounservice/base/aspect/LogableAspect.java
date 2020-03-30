package org.nounsys.nounservice.base.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Author gaoxu @Date 2019-05-28 16:58
 */
@Component
@Slf4j
@Aspect
public class LogableAspect {

    @Pointcut("@annotation(org.nounsys.nounservice.base.aspect.annotation.Logable)")
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object exec(final ProceedingJoinPoint point) throws Throwable {
        Class clazz = point.getTarget().getClass();
        String methodName = point.getSignature().getName();
        String methodFullName = new StringBuilder(clazz.getCanonicalName()).append(".").append(methodName).toString();
        Object[] parameters = point.getArgs();

        try {
            log.info("begin method name = {}, parameters = {}", methodFullName, parameters);
            long startTime = System.currentTimeMillis();
            Object ret = point.proceed();
            long endTime = System.currentTimeMillis();
            log.info("end method name = {},result = {} ,cost time = {}ms", ret, (endTime - startTime));
            return ret;
        } catch (Exception ex) {
            log.error("method name = {} execute error", methodFullName, ex);
            throw ex;
        }
    }
}
