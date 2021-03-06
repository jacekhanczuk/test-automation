package website.url;

import selenium.pagefactory.annotation.Page;

public class UrlResolver {

	public static String getUrl(Class<?> pageObjectClass) {
		if (pageObjectClass.isAnnotationPresent(Page.class)) {
			Page pageAnnotation = pageObjectClass.getAnnotation(Page.class);
			return pageAnnotation.baseUrl() + pageAnnotation.urlPath();
		}
		return null;
	}

}
