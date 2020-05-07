package com.example.log;

import java.lang.annotation.*;

/**
 * @author lishibo
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PrintLog {
}
