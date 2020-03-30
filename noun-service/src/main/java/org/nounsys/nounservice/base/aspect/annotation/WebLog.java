package org.nounsys.nounservice.base.aspect.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author : gaoxu
 * @date : Created on 2020/1/15
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value = {ElementType.METHOD})
public @interface WebLog {
    /**
     * 日志描述信息
     * @return
     */
    String description() default "";
}
