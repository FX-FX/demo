package com.example.log;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author 繁星
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(LogConfig.class)
public @interface EnableLog {
}
