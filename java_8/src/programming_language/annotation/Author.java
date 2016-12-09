package programming_language.annotation;

import java.lang.annotation.Repeatable;
/*
 * 通过注解 @Repeatable 声明可重复性
 * 并指明注解容器
 */
@Repeatable(value=Authors.class)
public @interface Author {
	String name() default "";
}
