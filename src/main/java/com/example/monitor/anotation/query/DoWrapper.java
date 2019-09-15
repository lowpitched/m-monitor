package com.example.monitor.anotation.query;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface DoWrapper {

    boolean wrapperIgnore() default false;

    String rawColumn() default "";

}
