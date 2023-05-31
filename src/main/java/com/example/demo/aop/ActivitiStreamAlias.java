package com.example.demo.aop;

import java.lang.annotation.*;

/**
 * Date: 5/29/2023<br/>
 * Time: 1:45 PM<br/>
 */
@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface ActivitiStreamAlias {

    String action();

    String description() default "";

    String category() default "";

    String subCategory() default "";

    boolean highPriority() default false;
}

