package website.url;

import website.pages.page.annotation.Page;

public class UrlResolver {

	public static String getUrl(Class<?> pageObjectClass, String baseUrl) {
		if (pageObjectClass.isAnnotationPresent(Page.class)) {
			Page pageAnnotation = pageObjectClass.getAnnotation(Page.class);
			return pageAnnotation.mainPage() ? baseUrl : baseUrl + pageAnnotation.urlPath();
		}
		return null;
	}

}
