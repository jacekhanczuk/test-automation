package api.selenium.pagefactory.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Selector {
	String xpath() default "";

	String id() default "";

	String className() default "";

	String css() default "";

	String linkText() default "";

	String tagName() default "";

}
