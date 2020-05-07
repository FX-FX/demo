package com.example.log;

import java.lang.annotation.*;

/**
 * @author 繁星
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PrintLog {
}
