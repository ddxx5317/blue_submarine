package io.blue.submarine.han.aop;


import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented

public @interface RouterDataSource {
	DataSource value() default DataSource.SLAVE;
}
