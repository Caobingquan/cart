package com.feign.annotation;

import java.lang.annotation.*;

/**
 * @author {曹炳全}
 * @Title LoginToken
 * @Description
 * @date 2019/12/19 16:30
 */

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LoginToken {
    boolean required() default true;
}
