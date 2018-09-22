package com.bcfou.inerface;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * 自定义注解
 * @Author: 编程否
 * @Date: 2018/9/22 16:50
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})//只能在方法上使用该注解
public @interface Log {
    /**
     * 日志描述，该注解是别名注解，spring提供
     */
    @AliasFor("desc")
    String value() default "";
    /**
     * 日志描述
     */
    @AliasFor("value")
    String desc() default "";
    /**
     * 是否不记录日志
     * @return
     */
    boolean ignore() default false;
}
