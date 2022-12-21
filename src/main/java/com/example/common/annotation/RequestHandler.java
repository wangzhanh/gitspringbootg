package com.example.common.annotation;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

/**
 * @author fanyuepan
 */
@Component
public @interface RequestHandler {

    @AliasFor(value = "value",annotation = Component.class)
    String serviceName() default "";

    @AliasFor(value = "serviceName")
    String value() default "";
}
