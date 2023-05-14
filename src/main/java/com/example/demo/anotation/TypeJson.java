package com.example.demo.anotation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Date: 5/12/2023<br/>
 * Time: 4:44 PM<br/>
 */
@Target({FIELD, METHOD})
@Retention(RUNTIME)
public @interface TypeJson {
    /**
     * The type implementation class.
     */
    Class<?> typeClass();
}