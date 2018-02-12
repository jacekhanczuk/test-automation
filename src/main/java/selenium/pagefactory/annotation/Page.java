package selenium.pagefactory.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import website.url.UrlAddresses;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Page {
	String urlPath() default "";

	String baseUrl() default UrlAddresses.MAIN_PAGE;
}
